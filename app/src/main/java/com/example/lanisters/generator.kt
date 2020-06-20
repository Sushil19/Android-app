package com.example.lanisters

//import com.google.zxing.qrcode.encoder.QRCode
import android.content.Context
import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.glxn.qrgen.android.QRCode

//import net.glxn.qrgen.android.QRCode



class generator : AppCompatActivity() {

    private var gen_txt: EditText? = null
    private var gen_btn: Button? = null
    private var mImagePreview: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)

        gen_txt = findViewById(R.id.gen_txt) as EditText
        gen_btn = findViewById(R.id.gen_btn) as Button
        mImagePreview = findViewById(R.id.imagePreview) as ImageView


        (gen_btn as Button).setOnClickListener {
            val text = (gen_txt as EditText).text.toString()

            if (text.isEmpty()) {
                Toast.makeText(this, getString(R.string.hint_enter_text_to_create_barcode),
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            /*
            * Generate bitmap from the text provided,
            * The QR code can be saved using other methods such as stream(), file(), to() etc.
            * */
            val bitmap = QRCode.from(text).withSize(1000, 1000).bitmap()
            (mImagePreview as ImageView).setImageBitmap(bitmap)
            hideKeyboard()
        }
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}

