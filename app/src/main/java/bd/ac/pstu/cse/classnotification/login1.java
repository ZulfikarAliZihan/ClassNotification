package bd.ac.pstu.cse.classnotification;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class login1 extends Fragment {

    Button loginBtn;
    EditText usernameEditText,passwordExitText;
    String name,pass;


    public login1() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Login");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_login1, container, false);

        loginBtn=(Button)v.findViewById(R.id.loginBtn);
        usernameEditText=(EditText)v.findViewById(R.id.usernameet);
        passwordExitText=(EditText)v.findViewById(R.id.passwordet);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=usernameEditText.getText().toString();
                pass=passwordExitText.getText().toString();





                if(name.equals("zehan")&&pass.equals("1234")){
                    setdata();
                    setclass1 s=new setclass1();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main1, s,s.getTag());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                else{
                    usernameEditText.setText("wrong entry");
                }
            }
        });




        autoLogin();

        return v;
    }

    public void setdata(){
        myreference.setMyReference(name,pass,getContext());
    }

    public void autoLogin(){
        if((myreference.getMyReference(getContext()).equals("zehan")) && (myreference.getMyReferencePass(getContext()).equals("1234"))){
            setclass1 s=new setclass1();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main1, s,s.getTag());
            ft.addToBackStack(null);
            ft.commit();

        }


    }

}
