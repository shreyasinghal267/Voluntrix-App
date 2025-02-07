package fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.voluntrix_app.LoginActivity
import com.example.voluntrix_app.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


/**
 * A simple [Fragment] subclass.
 * Use the [UserProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserProfileFragment : Fragment() {

    lateinit var navigationView: NavigationView

    lateinit var userName:TextView
    lateinit var userImg:ImageView
    lateinit var userEmail:TextView
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_user_profile, container, false )

        userImg=view.findViewById(R.id.userImg)
        userEmail=view.findViewById(R.id.userEmail)
        userName=view.findViewById(R.id.userName)


        val account = GoogleSignIn.getLastSignedInAccount(this.requireContext())
        if (account!=null){
            val name = account.displayName
            val email = account.email
            val photo = account.photoUrl
            userName.setText(name)
            userEmail.setText(email)
            Glide.with(this).load(photo).into(userImg);
        }
        auth = FirebaseAuth.getInstance()


        // Inflate the layout for this fragment
        return view
    }
}