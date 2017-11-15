package ch.epfl.sweng.qeeqbii;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.content.ContentValues.TAG;
import static ch.epfl.sweng.qeeqbii.MainActivity.BARCODE_READER;

/**
 * Created by sergei on 02/11/17.
 * Activity which uses the ZXing library with the me.dm7 wrapper
 * In order to scan barcodes
 * Each scanned barcode is then sent to the BarcodeToProductActivity via an intent
 * If the barcode is invalid or the back button was pressed
 * MainActivity is started via an intent
 */

public class BarcodeScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    // code for permission call
    private static final int ZXING_CAMERA_PERMISSION = 1;

    // zxing library object
    private ZXingScannerView mScannerView;

    // on activity creation
    // ask permissions and launch barcode reader
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // disable autorotate if it was enabled
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        setContentView(R.layout.activity_barcode_scanner);

        // request for camera permission if it is not present
        checkCameraPermissionAndRequest();

        // initialize ZXing scanner
        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);
    }

    // check if the camera permission is given
    // request one if it was not
    private void checkCameraPermissionAndRequest() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        }
    }

    // this method is called when system gives (or not gives) the permission to use camera
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, getString(R.string.camera_perm_ok));
                } else {
                    Toast.makeText(this, R.string.please_allow_camera, Toast.LENGTH_SHORT).show();
                }
        }
    }

    // when the activity is started again (ex. when application is switched into)
    // start the camera again
    @Override
    public void onResume() {
        super.onResume();

        // Register ourselves as a handler for scan results.
        mScannerView.setResultHandler(this);

        // Start camera on resume
        mScannerView.startCamera();
    }

    // when the app is in the background, switch the camera off
    @Override
    public void onPause() {
        super.onPause();

        // Stop camera on pause
        mScannerView.stopCamera();
    }

    // process the scanned barcode
    @Override
    public void handleResult(Result rawResult) {
        // Prints scan results
        Log.v(TAG, rawResult.getText());

        // Prints the scan format (qr code, pdf417 etc.)
        Log.v(TAG, rawResult.getBarcodeFormat().toString());

        String barcode = rawResult.getText();

        processBarcode(barcode);
    }

    // go to the main activity
    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // process the barcode given as a string
    public void processBarcode(String barcode) {
        // go back to main activity if the barcode was invalid
        // or the scan was interrupted
        if (barcode == null || barcode.equals("")) {
            Log.d("STATE", "Barcode is invalid, going back to main");
            goToMain();
        } else {
            Log.d("STATE", "Barcode " + barcode + " found, going to OpenFood");
            Intent intent = new Intent(this, BarcodeToProductActivity.class);
            intent.putExtra(BARCODE_READER, barcode);
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // go back to main activity after BACK button was pressed
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
