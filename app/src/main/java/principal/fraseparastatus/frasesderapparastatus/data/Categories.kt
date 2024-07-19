package principal.fraseparastatus.frasesderapparastatus.data

import principal.fraseparastatus.frasesderapparastatus.R

enum class Category{
    Rap, Trap
}

sealed class CategoryData(val imageResource: Int, val category: Category){
    data object CategoryRap: CategoryData(R.drawable.rap, Category.Rap)
    data object CategoryTrap: CategoryData(R.drawable.trap, Category.Trap)
}

val categories = listOf(CategoryData.CategoryRap, CategoryData.CategoryTrap)

