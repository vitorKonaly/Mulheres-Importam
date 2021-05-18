package com.konaly.mulhersimportamofc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konaly.mulhersimportamofc.R
import com.konaly.mulhersimportamofc.models.Produto
import com.konaly.mulhersimportamofc.models.ProdutoItem
import kotlinx.android.synthetic.main.produto_item.view.*

class ProdutosAdapter(private val items:Produto):RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder =
        ProdutosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.produto_item,parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ProdutosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(produtoItem: ProdutoItem) {
            Glide.with(itemView).load(produtoItem.path_thumb).centerCrop().into(itemView.imageProdutoItem)
            itemView.textNomeProdutoItem.text = produtoItem.nome
            itemView.textValorProdutoItem.text = produtoItem.valor_unitario
            itemView.textDescricaoProdutoItem.text = produtoItem.descricao
        }

    }
}