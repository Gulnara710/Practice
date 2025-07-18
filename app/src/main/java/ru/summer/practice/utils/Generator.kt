package ru.summer.practice.utils

import ru.summer.practice.model.ListPageItemModel
import kotlin.random.Random

object Generator {

    fun getListPageData(): List<ListPageItemModel> {
        return listOf(
            ListPageItemModel(
                imageUrl = "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg",
                title = "First cat sample",
                description = "First cat sfsfsgsg",
            ),
            ListPageItemModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoDim25Sj5loXJbpYM0NKMZI2geNtFbDme5A&s",
                title = "Second cat sample",
                description = "Second cat description",
            ),
            ListPageItemModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxMMWd08C5AE2EXAyUKJ_5SLvDntWHayN0uA&s",
                title = "Third cat sample",
                description = "Third cat description",
            ),
            ListPageItemModel(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoJtOn5gyW81kWToellszzxWObkGXQQL8m-w&s",
                title = "Fourth cat sample",
                description = "Fourth cat description",
            ),
            ListPageItemModel(
                imageUrl = "https://www.purina.in/sites/default/files/2020-12/Understanding%20Your%20Cat%27s%20Body%20LanguageTEASER.jpg",
                title = "Fifth cat sample",
                description = "Fifth cat description",
            ),
            ListPageItemModel(
                imageUrl = "https://images.unsplash.com/photo-1529778873920-4da4926a72c2?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Y3V0ZSUyMGNhdHxlbnwwfHwwfHx8MA%3D%3D",
                title = "Sixth cat sample",
                description = "Sixth cat description",
            ),
        )
    }

    fun getRandomCat(): ListPageItemModel {
        val list = getListPageData()

        val randomUrl = Random.nextInt(0, list.size)
        val randomTitle = Random.nextInt(0, list.size)
        val randomDesc = Random.nextInt(0, list.size)
        val url = list[randomUrl].imageUrl
        val title = list[randomTitle].title
        val descr = list[randomDesc].description
        return ListPageItemModel(
            imageUrl = url,
            title = title,
            description = descr,
        )
    }
}
