package com.example.kyrsovaya_client_v2.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.fragments.HomeFragment;
import com.example.kyrsovaya_client_v2.fragments.KabinetFragment;
import com.example.kyrsovaya_client_v2.fragments.LogoutFragment;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.Quiz;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatListActivity extends AppCompatActivity /*implements BottomNavigationView.OnNavigationItemSelectedListener*/ {


   /* public void Spisok()
    {
        ListView list = (ListView) findViewById(R.id.list);
        Call<List<Quiz>> call = RetrofitClient.getInstance().getApi().getQuizzes();

        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                List<Quiz> quiz = response.body();
                String[] quiznames = new String[quiz.size()];
                Integer[] quiz_id = new Integer[quiz.size()];


                for(int i = 0; i<quiz.size(); i++)
                {
                    quiznames[i] = quiz.get(i).getQuizname();
                    quiz_id[i] = quiz.get(i).getQuiz_id();

                }
                list.setAdapter(
                        new ArrayAdapter<Integer>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                quiz_id
                        )

                );
                list.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                quiznames
                        )

                );
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                        String value = quiznames[i];
                        Toast.makeText(ChatListActivity.this, value, Toast.LENGTH_SHORT).show();
                    }
                });


                // Log.d("123", "Пока");

               /* for(Quiz q:quiz)
                {
                    Log.d("quizname", q.getQuizname());
                }
            }*/

           /* @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Log.d("Беда", "БЕДА!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        });

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
       // Spisok();





        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
       //navigationView.setOnNavigationItemSelectedListener(this);

        //displayFragment(new HomeFragment());
    }

    private void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.new_layout_relative, fragment).commit();


    }


   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

   @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

  /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem ) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_user:
                fragment = new KabinetFragment();
                break;
            case R.id.menu_logout:
                fragment = new LogoutFragment();
                break;
        }
        if (fragment !=null){
            displayFragment(fragment);
        }
        return false;
    }*/


}

