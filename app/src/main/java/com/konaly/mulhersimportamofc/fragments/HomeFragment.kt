package com.konaly.mulhersimportamofc.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.konaly.mulhersimportamofc.MainActivity
import com.konaly.mulhersimportamofc.R
import com.konaly.mulhersimportamofc.adapter.ProdutosAdapter
import com.konaly.mulhersimportamofc.models.Produto
import com.konaly.mulhersimportamofc.models.ProdutoItem
import com.konaly.mulhersimportamofc.networks.ApiClient
import com.konaly.mulhersimportamofc.shared.SessionManage
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment() : Fragment() {

    private lateinit var sessionManager: SessionManage
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        listarProdutos()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun listarProdutos() {
        apiClient = ApiClient()
        sessionManager = SessionManage(requireContext())

        apiClient.getApiService(requireContext()).getProdutos()
            .enqueue(object : Callback<Produto>, ProdutosAdapter.ClickProduto {
                override fun onFailure(call: Call<Produto>, t: Throwable) {
                    Toast.makeText(requireContext(),"FALHA",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                    recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                    recyclerView.adapter = response.body()?.let { ProdutosAdapter(it,this) }


                }

                override fun clickProduto(produto: Produto) {
                    Toast.makeText(requireContext(),"jsdlfkj",Toast.LENGTH_SHORT).show()
                }
            })
    }



}