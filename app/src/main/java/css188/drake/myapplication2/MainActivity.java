package css188.drake.myapplication2;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private Button my_button;
    private EditText edit_text;
    private User[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_button = (Button) findViewById(R.id.button);
        edit_text = (EditText) findViewById(R.id.editText);

        User clayton = new User();
        clayton.setName("Clayton");
        clayton.setColor("Blue");

        User jeff = new User();
        jeff.setName("Jeff");
        jeff.setColor("Green");

        users = new User[]{clayton, jeff};

        UserAdapter adapter = new UserAdapter(this, users);
        setListAdapter(adapter);

        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CS188", "Hello");
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();

                String input = edit_text.getText().toString();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("value", input);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_1:
                //do something here
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String name = users[position].getName().toString();
        String color = users[position].getColor().toString();

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("value", name);
        intent.putExtra("color", color);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation
                (MainActivity.this, v.findViewById(R.id.userCell), "cell");

        startActivity(intent, options.toBundle());
    }
}
