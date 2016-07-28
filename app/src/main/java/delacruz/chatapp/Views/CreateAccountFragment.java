package delacruz.chatapp.Views;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import delacruz.chatapp.R;

/**
 * Extends CreateAccountActivity, handles all user input
 */
public class CreateAccountFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = CreateAccountFragment.class.getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public ProgressDialog mProgressDialog;

    @Bind(R.id.emailText)
    EditText mEmailText;
    @Bind(R.id.passwordText) EditText mPasswordText;
    @Bind(R.id.confirmPassText) EditText mConfirmPassText;
    @Bind(R.id.signUpButton)
    Button mSignUpButton;

    public CreateAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);

        ButterKnife.bind(getActivity());


        mSignUpButton.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }

        };
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpButton:
                createAccount(mEmailText.getText().toString(), mPasswordText.getText().toString());
                break;

        }
    }


    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount" + email);
        if(!validateForm()) {
            return;
        }
        showProgressDialog();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.

                        if (!task.isSuccessful()) {
                            Toast.makeText(getActivity(), R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        hideProgressDialog();
                    }
                });
    }
    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailText.getText().toString();
        if(TextUtils.isEmpty(email)) {
            mEmailText.setText("Email Required");
            valid = false;
        } else {
            mEmailText.setError(null);
        }

        String password = mPasswordText.getText().toString();
        if(TextUtils.isEmpty(password)) {
            mPasswordText.setText("Password Required");
            valid = false;
        } else {
            mPasswordText.setError(null);
        }

        return valid;
    }


    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
