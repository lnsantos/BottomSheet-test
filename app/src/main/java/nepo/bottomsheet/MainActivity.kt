package nepo.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Fazer o setup do ActionBar usando o Bottom App Bar e
        sobrescrever o método onCreateOptionsMenu para definir o menu de opções da Action Bar. */
        val myBottomAppBar = bottomAppBar
        setSupportActionBar(myBottomAppBar)

        imageView_menu.setOnClickListener{
            val button: com.google.android.material.bottomsheet.BottomSheetDialogFragment = BottomSheetDialogFragment()
            button.show(supportFragmentManager,button.tag)

        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.favs){
            toast("Item selecionado: favoritos");
            return true
        }else if(id == R.id.search){
            toast("Item selecionado: procurar");
            return true
        }
        return super.onOptionsItemSelected(item);
    }

    private fun toast(message: String) {
        val toaster = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
