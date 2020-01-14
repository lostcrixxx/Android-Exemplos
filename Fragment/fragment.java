Aqui estão alguns caminhos possíveis de armazenamento externo:

/ storage / sdcard1 //! <Motorola Xoom
/ storage / extsdcard //! <Samsung SGS3
/ storage / sdcard0 / external_sdcard // solicitação do usuário
/ mnt / extsdcard
/ mnt / sdcard / external_sd //! <Samsung galaxy family
/ mnt / external_sd
/ mnt / media_rw / sdcard1 //! <4.4.2 no CyanogenMod S3
/ removível / microsd //! <Transformador Asus prime
/ mnt / emmc
/ storage / external_SD //! <LG
/ storage / ext_sd //! <HTC One Max
/ storage / removível / sdcard1 //! <Sony Xperia Z1
/ data / sdext
/ data / sdext2
/ data / sdext3
/ data / sdext4


// ** //
// Class
import android.app.DialogFragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.nomadlog.nlcsvdataviewer.R;

public class AboutFragment extends DialogFragment {

    String pathError;

    static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);

        pathError = getArguments().getString("EXTRA_PATHFILE_ERROR");

        PackageManager manager = getContext().getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(getContext().getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        View tv = v.findViewById(R.id.textView);
        ((TextView) tv).setText("2020 "
                + "\n"
                + "\nPackageName = " + info.packageName
                + "\nVersão = " + info.versionName
                + "\n"
                + "\nCaminho da pasta = " + (Environment.getExternalStoragePublicDirectory("nomePasta") + "/nomeDoArquivo.csv")
                + "\nPATH = " + pathError
        );

        return v;
    }
}

// XML hello_world
<?xml version="1.0" encoding="utf-8"?>

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceMedium"
        android:text="Sobre"
        android:id="@+id/textView"
        android:padding="10dp"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true" />

</RelativeLayout>

// chama fragment
    void showDialog() {
        DialogFragment aboutFragment = new AboutFragment();

        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_PATHFILE_ERROR", pathFileError);
        aboutFragment.setArguments(bundle);

        aboutFragment.show(getFragmentManager(), "dialog");
    }