package com.konaly.mulhersimportamofc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.konaly.mulhersimportamofc.fragments.CarrinhoFragment
import com.konaly.mulhersimportamofc.fragments.FavoritosFragment
import com.konaly.mulhersimportamofc.fragments.HomeFragment
import com.konaly.mulhersimportamofc.models.Produto
import com.konaly.mulhersimportamofc.models.ProdutoItem
import com.konaly.mulhersimportamofc.networks.ApiClient
import com.konaly.mulhersimportamofc.shared.SessionManage
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaInicial : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var homeFragment: HomeFragment
    private lateinit var favoritosFragment: FavoritosFragment
    private lateinit var carrinhoFragment: CarrinhoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        supportActionBar!!.hide()
        bottomNavigationView = bottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        homeFragment = HomeFragment()
        favoritosFragment = FavoritosFragment()
        carrinhoFragment = CarrinhoFragment()
        setFragment(homeFragment)

    }

    private fun setFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager .beginTransaction()
        fragmentTransaction.replace(R.id.containerProduto,fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuHome -> {
                setFragment(homeFragment)
            }
            R.id.menuFavoritos -> {
                setFragment(favoritosFragment)
            }
            R.id.menuCarrinho -> {
                setFragment(carrinhoFragment)
            }

        }
        return true
    }
}