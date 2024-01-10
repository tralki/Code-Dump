package com.example.projetomobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetomobile.R
import com.example.projetomobile.databinding.ItemAssetBinding
import com.example.projetomobile.models.Asset

class SearchAdapter(
        private val searchResults: List<Asset>,
        private val onItemClick: (Asset, Boolean) -> Unit
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

        inner class SearchViewHolder(private val binding: ItemAssetBinding) :
                RecyclerView.ViewHolder(binding.root) {

                init {
                        itemView.setOnClickListener {
                                val position = bindingAdapterPosition
                                if (position != RecyclerView.NO_POSITION) {
                                        val clickedItem = searchResults[position]
                                        onItemClick(clickedItem, !clickedItem.isMonitored)
                                }
                        }
                }

                fun bind(asset: Asset) {
                        // Atualizar o conteúdo do SearchViewHolder com os dados do item
                        binding.AssetSymbol.text = asset.symbol
                        binding.AssetPrice.text = "Price: ${asset.currentPrice}"
                        binding.AssetChangePercent.text = "Change Percent: ${asset.percentChange}%"
                        binding.assetCheckbox.isChecked = asset.isMonitored

                        // Agora você pode usar o Glide ou Picasso para carregar a imagem
                        // Aqui está um exemplo usando Glide
                        Glide.with(itemView)
                                .load(asset.logoUrl)
                                .placeholder(R.drawable.loading_image) // adicione um placeholder se desejar
                                .error(R.drawable.error_image) // adicione uma imagem de erro se desejar
                                .into(binding.AssetLogo)
                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
                // Inflar o layout do item e criar uma instância do SearchViewHolder
                val binding =
                        ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return SearchViewHolder(binding)
        }

        override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
                // Chamar o método bind do ViewHolder para atualizar os dados do item
                holder.bind(searchResults[position])
        }

        override fun getItemCount(): Int {
                return searchResults.size
        }
}