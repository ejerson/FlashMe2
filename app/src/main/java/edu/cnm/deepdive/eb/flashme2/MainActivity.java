package edu.cnm.deepdive.eb.flashme2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import edu.cnm.deepdive.eb.flashme2.fragments.DeckFragment;
import edu.cnm.deepdive.eb.flashme2.fragments.DeckMemberFragment;

public class MainActivity extends AppCompatActivity {

  FragmentManager manager = getSupportFragmentManager();
  Fragment fragment = manager.findFragmentById(R.id.fragment_container);


  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_deck:
          fragment = new DeckFragment();
          Bundle args = new Bundle();
          fragment.setArguments(args);
          manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
          return true;
        case R.id.navigation_leitner:
          fragment = new DeckMemberFragment();
          Bundle args1 = new Bundle();
          fragment.setArguments(args1); // bundle
          manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
          return true;
        case R.id.navigation_settings:

          return true;
      }
      return false;
    }

  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main_fragment);

    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
  }

  public void goToDeckMemberFragment(View view) {
//      startActivity(new Intent(DeckActivity.this, CardActivity.class));
    fragment = new DeckMemberFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args); // bundle
    manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

  }

}
