package com.toast_custom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private static int gravity; // Gravity variable for gravity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Implement click listener over button
		findViewById(R.id.show_toast).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				showAlerDialog();// Show alert dialog

			}
		});
	}

	// Alert dialog method for selecting gravity of toast
	private void showAlerDialog() {
		CharSequence[] alertItems = { "TOP", "CENTRE", "BOTTOM" }; // Aler
																	// dialog
																	// listitems
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Choose Toast Gravity"); // builder title

		// Setting list items and clicklistener over it
		builder.setItems(alertItems, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int position) {

				// Switch statement for position and setting gravity according
				// to selected position and calling custom toast method by
				// passing selected gravity
				switch (position) {
				case 0:
					gravity = Gravity.TOP;
					showCustomToast(gravity);
					break;

				case 1:
					gravity = Gravity.CENTER;
					showCustomToast(gravity);
					break;
				case 2:
					gravity = Gravity.BOTTOM;
					showCustomToast(gravity);
					break;
				default:
					gravity = Gravity.CENTER;
					showCustomToast(gravity);
					break;
				}
			}
		});
		AlertDialog ad = builder.create();
		ad.setCancelable(true);
		ad.setCanceledOnTouchOutside(true);
		ad.show(); // Show dialog
	}

	// Custom toast method
	private void showCustomToast(int gravity_type) {
		LayoutInflater inflater = getLayoutInflater(); // Layout inflater for
														// custom inflater
		View view = inflater.inflate(R.layout.custom_toast,
				(ViewGroup) findViewById(R.id.container)); // inflating custom
															// view

		// By finding views id you can change their value at run time by
		// changing imageview image and textview text
		ImageView custom_toast_image = (ImageView) view
				.findViewById(R.id.custom_toast_image);
		TextView custom_toast_text = (TextView) view
				.findViewById(R.id.custom_toast_text);

		// Getting toast
		Toast toast = new Toast(MainActivity.this);
		toast.setGravity(gravity_type, 0, 0);// Setting gravity and margin
		toast.setDuration(Toast.LENGTH_LONG);// Duration of toast
		toast.setView(view);// Setting custom view
		toast.show();// finally showing toast
	}

}
