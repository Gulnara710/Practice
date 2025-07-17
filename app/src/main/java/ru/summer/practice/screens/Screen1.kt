package ru.summer.practice.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.summer.practice.R
import ru.summer.practice.adapter.ListPageAdapter
import ru.summer.practice.model.ListPageItemModel
import ru.summer.practice.utils.Generator


class Screen1 : Fragment() {
    private lateinit var adapter: ListPageAdapter
    private lateinit var models: MutableList<ListPageItemModel>
    private lateinit var allImageUrls: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.screen1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val fullList = Generator.getListPageData()
        models = fullList.take(9).toMutableList()
        allImageUrls = fullList.map { it.imageUrl }

        adapter = ListPageAdapter(models,
            onItemClick = { position ->
                val model = models[position]
                val bundle = Bundle().apply {
                    putSerializable("model", model)
                }
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            },
            onImageClick = { position ->
                val newImage = allImageUrls.random()
                models[position] = models[position].copy(imageUrl = newImage)
                adapter.updateItem(position, models[position])
            }
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}