package ch.epfl.sweng.qeeqbii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ShoppingCartActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;
    private ShoppingCart cart = new ShoppingCart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_shopping_cart);

        RecyclerView = (RecyclerView)findViewById(R.id.recycler);
        //create and set layout manager for each RecyclerView
        RecyclerView.LayoutManager firstLayoutManager = new LinearLayoutManager(this);

        RecyclerView.setLayoutManager(firstLayoutManager);

        //Initializing and set adapter for each RecyclerView
        RecyclerViewAdapter firstAdapter = new RecyclerViewAdapter(this, cart.getItemsInCart());

        RecyclerView.setAdapter(firstAdapter);
    }

    public void showShoppingList(View view) {
        Intent intent = new Intent(this, ShoppingListActivity.class);
        startActivity(intent);
    }
}
