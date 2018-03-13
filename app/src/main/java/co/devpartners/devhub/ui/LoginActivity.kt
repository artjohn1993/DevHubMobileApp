package co.devpartners.devhub.ui


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import co.devpartners.devhub.R
import co.devpartners.devhub.service.Maps
import kotlinx.android.synthetic.main.activity_userlogin.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlogin)
        supportActionBar?.hide()
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)




        locationText.setOnClickListener {
            startActivity<Maps>()
        }

        submitButton.setOnClickListener {
//            if(usernameEditText.text.toString()=="AkoSiMalakas" && passwordEditText.text.toString()=="AkoBudoy"){
                startActivity<MainActivity>()
                finish()
//            }else{
//                Toast.makeText(this,"Invalid username or password.",Toast.LENGTH_LONG).show()
//            }
        }
        createAccountTextView.setOnClickListener {
            startActivity<AccountRegisterActivity>()
        }
    }
}