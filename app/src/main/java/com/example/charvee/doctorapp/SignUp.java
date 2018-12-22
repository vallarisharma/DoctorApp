package com.example.charvee.doctorapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.charvee.doctorapp.Timer_pack.TimePickerFragment;
import com.xwray.passwordview.PasswordView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignUp.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp extends android.support.v4.app.Fragment implements TimePickerDialog.OnTimeSetListener {

    int  RESULT_LOAD_IMAGE=1;
    View view;
    PasswordView pv_password, pv_confirmPass;
    TextInputLayout til_password;
    EditText firstname, lastname, email, Mfromtime, Mtotime,Efromtime,Etotime,location,area,emergencyNo,phoneNo,pincode,description,clinicName,costCharges;
    Button signup,uploadimage;
    Switch switchdisplay;
    RadioButton morning,evening,male,female;
    RadioGroup rg_timings;
    CheckBox all,monday,tuesday,wednesday,thursday,friday,saturday,sunday;
    ImageView imageView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUp.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUp newInstance(String param1, String param2) {
        SignUp fragment = new SignUp();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SignUp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);


        createIds();
        switchdisplay.setTextOff("Off");
        switchdisplay.setTextOn("On");
        switchdisplay.setShowText(true);



        all.setOnCheckedChangeListener(new
                                               CompoundButton.OnCheckedChangeListener() {
                                                   @Override
                                                   public void onCheckedChanged(CompoundButton buttonView, boolean
                                                           isChecked) {
                                                       if (all.isChecked()) {
                                                           monday.setChecked(true);
                                                           tuesday.setChecked(true);
                                                           wednesday.setChecked(true);
                                                           thursday.setChecked(true);
                                                           friday.setChecked(true);
                                                           saturday.setChecked(true);
                                                           sunday.setChecked(true);

                                                       } else {
                                                           monday.setChecked(false);
                                                           tuesday.setChecked(false);
                                                           wednesday.setChecked(false);
                                                           thursday.setChecked(false);
                                                           friday.setChecked(false);
                                                           saturday.setChecked(false);
                                                           sunday.setChecked(false);
                                                       }
                                                   }
                                               });

        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        //String frstname,lstname,emailsignup;

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String frstname = firstname.getText().toString();
                String lstname = lastname.getText().toString();
                String emailsignup = email.getText().toString().trim();

                if (TextUtils.isEmpty(frstname)) {
                    firstname.setError("Firstname should not be empty");
                }
                else if (TextUtils.isEmpty(lstname)) {
                    lastname.setError("Lastname should not be empty");
                }
                else if (!emailsignup.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
                    email.setError("Invalid email");
                //else if (!pv_password.getText().toString().matches(pv_confirmPass.getText().toString()))

                /*else if (pv_password.getText().toString().matches(pv_confirmPass.getText().toString())) {
                        til_password.setError(null);
                        til_password.setErrorEnabled(false);
                    }*/
                else
                {
                    postData();
                }

            }
        });
        Mfromtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setTime(Mfromtime);
            }
        });
        Mtotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(Mtotime);
            }
        });
        Efromtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(Efromtime);
            }
        });
        Etotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(Etotime);

            }
        });
        /*signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });*/


        return view;
    }

    private void postData() {



            String url = "http://103.206.248.235:15000/doctorapi/docreg";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    NetworkResponse response = error.networkResponse;
                    if (error instanceof ServerError && response != null) {
                        try {
                            String res = new String(response.data,
                                    HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                            // Now you can use any deserializer to make sense of data
                            JSONObject obj = new JSONObject(res);
                        } catch (UnsupportedEncodingException e1) {
                            // Couldn't properly decode data to string
                            e1.printStackTrace();
                        } catch (JSONException e2) {
                            // returned data is not JSONObject?
                            e2.printStackTrace();
                        }
                    }
                }
            }) {
                //adding parameters to the request
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("fname",firstname.getText().toString());
                    params.put("lname",lastname.getText().toString());
                    params.put("email",email.getText().toString());
                    params.put("gender","M");
                    params.put("cname", clinicName.getText().toString());
                    params.put("shift","E" );
                    params.put("timemor",Mfromtime.getText().toString()+"-"+Mtotime.getText().toString() );
                    params.put("timeeve",Efromtime.getText().toString()+"-"+Etotime.getText().toString());
                    params.put("wday", "M");
                    params.put("cost",(costCharges.getText().toString()));
                    params.put("password", pv_password.getText().toString());
                    params.put("phone","123");
                    params.put("mob", emergencyNo.getText().toString());
                    params.put("descr",description.getText().toString() );
                    params.put("address",location.getText().toString() );
                    params.put("beds","2" );
                    params.put("area",area.getText().toString());
                    params.put("pincode",(pincode.getText().toString()));
                    return params;
                }
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                return headers;
            }
            };
            // Add the request to the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());
            queue.add(stringRequest);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);

            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            cursor.close();
        } else {
            Toast.makeText(getActivity(), "Try Again!!", Toast.LENGTH_SHORT)
                    .show();
        }

    }

    private void createIds() {
        imageView=(ImageView)view.findViewById(R.id.imageView);
        firstname = (EditText) view.findViewById(R.id.firstname);
        lastname = (EditText) view.findViewById(R.id.lastname);
        email = (EditText) view.findViewById(R.id.email);
        signup = (Button) view.findViewById(R.id.signup);
        switchdisplay = (Switch) view.findViewById(R.id.switchdisplay);
        pv_password = (PasswordView) view.findViewById(R.id.pv_password);
        til_password = (TextInputLayout) view.findViewById(R.id.til_password);
        pv_confirmPass = (PasswordView) view.findViewById(R.id.pv_confirmPassword);
        Mfromtime = (EditText) view.findViewById(R.id.timefrom);
        Mtotime = (EditText) view.findViewById(R.id.timeto);
        Efromtime=(EditText)view.findViewById(R.id.efrom);
        Etotime=(EditText)view.findViewById(R.id.eto);
        morning=(RadioButton)view.findViewById(R.id.morning);
        evening=(RadioButton)view.findViewById(R.id.evening);
        rg_timings=(RadioGroup)view.findViewById(R.id.rg_timings);
        all=(CheckBox)view.findViewById(R.id.all);
        monday=(CheckBox)view.findViewById(R.id.monday);
        tuesday=(CheckBox)view.findViewById(R.id.tuesday);
        wednesday=(CheckBox)view.findViewById(R.id.wednesday);
        thursday=(CheckBox)view.findViewById(R.id.thursday);
        friday=(CheckBox)view.findViewById(R.id.friday);
        saturday=(CheckBox)view.findViewById(R.id.saturday);
        sunday=(CheckBox)view.findViewById(R.id.sunday);
        uploadimage=(Button)view.findViewById(R.id.upload);
        phoneNo=(EditText)view.findViewById(R.id.et_phoneno);
        emergencyNo=(EditText)view.findViewById(R.id.emergencyno);
        location=(EditText)view.findViewById(R.id.location);
        area=(EditText)view.findViewById(R.id.area);
        description=(EditText)view.findViewById(R.id.et_description);
        pincode=(EditText)view.findViewById(R.id.Pincode);
        clinicName=(EditText)view.findViewById(R.id.clinicName);
        costCharges=(EditText)view.findViewById(R.id.costCharges);

    }

    public void setTime(final EditText Et_time)
    {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        ;
        TimePickerDialog  mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                Et_time.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
