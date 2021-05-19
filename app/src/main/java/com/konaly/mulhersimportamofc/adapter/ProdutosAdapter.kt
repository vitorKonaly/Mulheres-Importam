package com.konaly.mulhersimportamofc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konaly.mulhersimportamofc.R
import com.konaly.mulhersimportamofc.models.Produto
import com.konaly.mulhersimportamofc.models.ProdutoItem
import kotlinx.android.synthetic.main.produto_item.view.*
import okio.blackholeSink

class ProdutosAdapter(private val items:Produto, var clickProduto: ClickProduto ):RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder =
        ProdutosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.produto_item,parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        holder.bind(items[position])
        holder.cardView.setOnClickListener {
            clickProduto.clickProduto(items)
        }

    }

    interface ClickProduto{
        fun clickProduto(produto: Produto){

        }
    }

    inner class ProdutosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(produtoItem: ProdutoItem) {
            Glide.with(itemView).load(produtoItem.path_thumb).centerCrop().into(itemView.imageProdutoItem)
            itemView.textNomeProdutoItem.text = produtoItem.nome
            itemView.textValorProdutoItem.text = produtoItem.valor_unitario
            itemView.textDescricaoProdutoItem.text = produtoItem.descricao




        }
        var cardView = itemView.cardItem

    }
}