package owl.app.elsalmon.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import jp.wasabeef.blurry.Blurry;
import owl.app.elsalmon.R;
import owl.app.elsalmon.email.Config;
import owl.app.elsalmon.email.SendMail;

public class ContactanosFragment extends Fragment implements View.OnClickListener{

    private EditText nombre;
    private EditText apellidos;
    private EditText telefono;
    private EditText correo;
    private EditText empresa;
    private EditText mensaje;

    private FloatingActionButton fab;

    private View view;

    public ContactanosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contactanos, container, false);

        view.post(new Runnable() {
            @Override
            public void run() {
                long startMs = System.currentTimeMillis();
                Blurry.with(getContext())
                        .radius(25)
                        .sampling(2)
                        .async()
                        .animate(500)
                        .capture(getView().findViewById(R.id.imageContactanos))
                        .into((ImageView)getView().findViewById(R.id.imageContactanos));
            }
        });

        inicializaciones();

        fab.setOnClickListener(this);

        return view;
    }

    private void inicializaciones(){
        nombre = (EditText)view.findViewById(R.id.editTextNombre);
        apellidos = (EditText)view.findViewById(R.id.editTextApellidos);
        telefono = (EditText)view.findViewById(R.id.editTextTelefono);
        correo = (EditText)view.findViewById(R.id.editTextCorreo);
        empresa = (EditText)view.findViewById(R.id.editTextEmpresa);
        mensaje = (EditText)view.findViewById(R.id.editTextMensaje);

        fab = (FloatingActionButton)view.findViewById(R.id.FabEnviarMensaje);
    }

    private void sendEmail() {
        //Getting content for email
        String Nom = nombre.getText().toString().trim();
        String Ape = apellidos.getText().toString().trim();
        String Tel = telefono.getText().toString().trim();
        String Cor = correo.getText().toString().trim();
        String Emp = empresa.getText().toString().trim();
        String Men = mensaje.getText().toString().trim();

        String message = "Nombre: " +Nom + "\n"
                + "Apellido: " +Ape + "\n"
                + "Telefono: " +Tel + "\n"
                + "Correo: " +Cor + "\n"
                + "Mensaje:\n"
                + Men;

        if (TextUtils.isEmpty(Nom)) {
            nombre.setError(getString(R.string.ingreseNombre));
            nombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Ape)) {
            apellidos.setError(getString(R.string.ingreseApellidos));
            apellidos.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Tel)) {
            telefono.setError(getString(R.string.ingreseTelefono));
            telefono.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Cor)) {
            correo.setError(getString(R.string.ingreseCorreo));
            correo.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Men)) {
            mensaje.setError(getString(R.string.ingreseMensaje));
            mensaje.requestFocus();
            return;
        }

        //Creating SendMail object
        SendMail sm = new SendMail(getActivity(), Config.DESTINATARIO, Emp, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View view) {
        sendEmail();
        /*
        if(Network.isOnlineNet()) {
        } else {
            Toast.makeText(getActivity(), "No hay conexión", Toast.LENGTH_LONG).show();
        }*/
    }
}
