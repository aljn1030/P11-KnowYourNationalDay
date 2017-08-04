package sg.edu.rp.p11_knowyournationalday;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    private ArrayAdapter<String> listAdapter;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);

        String[] listArray = {  "Singapore National Day is on 9 Aug",
                "Singapore is 52 years old",
                "Theme is '#OneNationTogether'"
        };
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listArray);
        lv.setAdapter(adapter);

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout passPhrase =
                (LinearLayout) inflater.inflate(R.layout.passphrase, null);
        final EditText etPassphrase = (EditText) passPhrase
                .findViewById(R.id.editTextPassPhrase);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please Login")
                .setView(passPhrase)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if(etPassphrase.getText().toString().equals("738964") ){
                            Toast.makeText(MainActivity.this, "Welcome",
                                    Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "You clicked no",
                                    Toast.LENGTH_LONG).show();
                        }


                    }
                })
        .setNegativeButton("No Access Code", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this, "You clicked no",
                        Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            if (item.getItemId() == R.id.itemSend) {

                String[] list = new String[]{"Email", "SMS"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Select the way to enrich your friend")
                        // Set the list of items easily by just supplying an
                        //  array of the items
                        .setItems(list, new DialogInterface.OnClickListener() {
                            // The parameter "which" is the item index
                            // clicked, starting from 0
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else if (item.getItemId() == R.id.itemQuiz) {
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase =
                        (LinearLayout) inflater.inflate(R.layout.passphrase, null);
                final EditText etPassphrase = (EditText) passPhrase
                        .findViewById(R.id.editTextPassPhrase);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Please Enter")
                        .setView(passPhrase)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "You had entered " +
                                        etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }else if (item.getItemId() == R.id.itemQuit) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Quit?")
                        // Set text for the positive button and the corresponding
                        //  OnClickListener when it is clicked
                        .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        // Set text for the negative button and the corresponding
                        //  OnClickListener when it is clicked
                        .setNegativeButton("Not Really", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "You clicked no",
                                    Toast.LENGTH_LONG).show();
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }

            return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;


    }
}
