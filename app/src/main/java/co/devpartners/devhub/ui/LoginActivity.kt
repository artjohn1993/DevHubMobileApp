package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_login_.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_)
        supportActionBar?.hide()

        submitButton.setOnClickListener {
            if (usernameEditText.text.toString() == "JuanBoslot" && passwordEditText.text.toString() == "password"){
                startActivity<MainActivity>()
                finish()
            }else{
                Toast.makeText(this,"Invalid username or password.",Toast.LENGTH_SHORT).show()
            }
        }
        createAccountTextView.setOnClickListener {
            startActivity<AccountRegisterActivity>()
        }
    }
}
