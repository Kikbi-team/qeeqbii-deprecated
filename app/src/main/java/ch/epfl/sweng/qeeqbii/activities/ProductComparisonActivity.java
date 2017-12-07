package ch.epfl.sweng.qeeqbii.activities;

/*
Created by sergei on 30 Nov 2017

This class implements a product comparison activity
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import ch.epfl.sweng.qeeqbii.R;
import ch.epfl.sweng.qeeqbii.comparison.ComparisonGraphAdapter;
import ch.epfl.sweng.qeeqbii.comparison.ProductsLine;
import ch.epfl.sweng.qeeqbii.custom_exceptions.ProductException;
import ch.epfl.sweng.qeeqbii.open_food.Product;
import ch.epfl.sweng.qeeqbii.open_food.RecentlyScannedProducts;

import static java.lang.Double.parseDouble;


public class ProductComparisonActivity extends AppCompatActivity {

    private ComparisonGraphAdapter adapter = null;

    // add data to a bar chart
    public static void setData(HorizontalBarChart chart, ProductsLine line) {
        ArrayList<ProductsLine> lines = new ArrayList<ProductsLine>();
        lines.add(line);
        setData(chart, lines);
    }

    // add multiple lines to a bar chart
    private static void setData(HorizontalBarChart chart, ArrayList<ProductsLine> lines) {
        chart.getXAxis().setPosition(XAxis.XAxisPosition.TOP);
        chart.getDescription().setText("");

        chart.getAxisLeft().setAxisMinimum(0);

        final int bars_per_line = 3;
        final int line_n = lines.size();

        ArrayList<String> labels = new ArrayList<String>();
        for (int i = 0; i < line_n * bars_per_line; i++)
            labels.add("");

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        ArrayList<BarEntry> valueSet2 = new ArrayList<>();

        int i = 0;
        for (ProductsLine line : lines) {
            valueSet1.add(new BarEntry(i * bars_per_line, line.value1.floatValue()));
            valueSet2.add(new BarEntry(i * bars_per_line + 1, line.value2.floatValue()));
            labels.set(i * bars_per_line, line.criteria);
            i += 1;
        }

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Product 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));

        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Product 2");
        barDataSet1.setColor(Color.rgb(155, 0, 0));

        BarData data = new BarData();
        data.addDataSet(barDataSet1);
        data.addDataSet(barDataSet2);
        chart.setData(data);

        LabelFormatter formatter = new LabelFormatter(line_n > 1 ? labels : null);
        chart.getXAxis().setValueFormatter(formatter);

        chart.setDrawGridBackground(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setDrawLabels(false);

        if (line_n == 1)
            chart.getDescription().setText(lines.get(0).criteria);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_comparison);

        // creating list adapter
        adapter = new ComparisonGraphAdapter();
        adapter.setContext(getApplicationContext());

        // obtaining nutrients of products
        // using last two recently scanned products
        LinkedList<String> barcodes = RecentlyScannedProducts.getBarcodeList();
        if(barcodes.size() < 2) {
            Toast.makeText(this, R.string.scan_at_least_two, Toast.LENGTH_SHORT).show();
            Log.d("STATE", "Insufficient products");
            return;
        }
        else {
            Product product1 = RecentlyScannedProducts.getProduct(barcodes.get(barcodes.size() - 1));
            Product product2 = RecentlyScannedProducts.getProduct(barcodes.get(barcodes.size() - 2));

            // setting names of products
            TextView name1 = (TextView) findViewById(R.id.product_name_1);
            TextView name2 = (TextView) findViewById(R.id.product_name_2);

            name1.setText(product1.getName());
            name2.setText(product2.getName());

            Map<String, Double> nutrients1;
            Map<String, Double> nutrients2;

            String quantity1 = product1.getQuantity();
            String quantity2 = product2.getQuantity();

            Log.d("STATE", "Q1 " + quantity1 + " Q2 " + quantity2);

            // Adding quantity chart
            if(quantity1.length() > 0 && quantity2.length() > 0 &&
                (quantity1.substring(quantity1.length() - 1).equals(quantity2.substring(quantity2.length() - 1)))) {
                adapter.addLine(new ProductsLine("Quantity (" + quantity2.substring(quantity2.length() - 1) + ")",
                        parseDouble(quantity1.substring(0, quantity1.length() - 1)),
                        parseDouble(quantity2.substring(0, quantity2.length() - 1))));
            }

            try {
                nutrients1 = product1.getParsedNutrients();
                nutrients2 = product2.getParsedNutrients();
            } catch (ProductException e) {
                Toast.makeText(this, R.string.cannot_obtain_nutrients, Toast.LENGTH_SHORT).show();
                Log.d("STATE", String.valueOf(R.string.cannot_obtain_nutrients));
                e.printStackTrace();
                return;
            }

            // if nutrient is present in both products, showing the chart
            for(Map.Entry<String, Double> entry : nutrients1.entrySet()) {
                if(nutrients2.containsKey(entry.getKey())) {
                    ProductsLine line = new ProductsLine(entry.getKey(), entry.getValue(), nutrients2.get(entry.getKey()));
                    adapter.addLine(line);
                    Log.d("STATE", "Adding product" + line.criteria + " " + line.value1 + " " + line.value2);
                }
            }

        }

        ListView list = (ListView) findViewById(R.id.graphs);
        list.setAdapter(adapter);

    }

    // scan barcode button handler
    public void scanBarcode(View w) {
        Intent intent = new Intent(this, BarcodeScannerActivity.class);
        startActivity(intent);
    }

    // formatter for axis which outputs pre-defined values
    public static class LabelFormatter implements IAxisValueFormatter {
        private final ArrayList<String> mLabels;

        public LabelFormatter(ArrayList<String> labels) {
            mLabels = labels;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            int idx = (int) value;
            if (mLabels != null && (float) idx - value < 1e-2)
                return mLabels.get(idx);
            else return "";
        }
    }
}
