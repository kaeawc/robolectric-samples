package com.example.activity;

import android.view.Menu;

import com.example.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

import com.example.activity.robolectric.Robo;

@RunWith(Robo.class)
public class MainActivityTest {

  @Test
  public void onCreate_shouldInflateLayout() throws Exception {
    final MainActivity activity = Robolectric.setupActivity(MainActivity.class);

    final Menu menu = shadowOf(activity).getOptionsMenu();
    assertThat(menu.findItem(R.id.item1).getTitle()).isEqualTo("First menu item");
    assertThat(menu.findItem(R.id.item2).getTitle()).isEqualTo("Second menu item");
  }
}
