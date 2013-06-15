package com.sebastien.screen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erwanix.gsb.R;
import com.sebastien.db.DatabaseHelper;

public class AjoutClient extends Activity implements OnClickListener {

	private Button btn_addrecord;
	private EditText txtpname, txtpprice, txtpid;
	DatabaseHelper db;
	ClientModel pm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addrecord);

		txtpname = (EditText) findViewById(R.id.txtpname);
		txtpprice = (EditText) findViewById(R.id.txtpprice);
		btn_addrecord = (Button) findViewById(R.id.btn_addrecord);

		txtpid = (EditText) findViewById(R.id.txtpid);
		btn_addrecord.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_addrecord:

			if (txtpname.getText().toString().equals("")
					|| txtpprice.getText().toString().equals("")) {
				Toast.makeText(AjoutClient.this, "Merci d'ajouter des valeurs..",
						Toast.LENGTH_LONG).show();
			} else {

				db = new DatabaseHelper(getApplicationContext());
				db.getWritableDatabase();
				pm = new ClientModel();
				pm.idno = (txtpid.getText().toString());
				pm.productname = txtpname.getText().toString();
				pm.productprice = txtpprice.getText().toString();

				Log.i("idno,productname,productprice", "" + pm.idno + ""
						+ pm.productname + "" + pm.productprice);
				db.addProduct(pm);
				Toast.makeText(AjoutClient.this, "L'utilisateur a bien été enregistré.",
						Toast.LENGTH_LONG).show();
			}
			break;

		default:
			break;
		}

	}
}

