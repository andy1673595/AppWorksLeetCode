/**
Time : initialization = O(NLogN)
       changeRating = O(LogN)
       highestRated = O(1)
Space: O(N)
 */
class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    val ratingMap = mutableMapOf<String, SortedSet<Food>>()
    val map = mutableMapOf<String, Food>()

    init {
        for (i in foods.indices) {
            val f = Food(foods[i], cuisines[i], ratings[i])
            map[f.name] = f
            ratingMap[f.cuisine] = (ratingMap[f.cuisine] ?: sortedSetOf(Comparator<Food> { f1, f2 ->
                if (f1.rating == f2.rating) {
                    f1.name.compareTo(f2.name)
                } else {
                    f2.rating - f1.rating
                }
            })).apply {
                add(f)
            }
        }
    }
    fun changeRating(food: String, newRating: Int) {
        val originFood = map[food]!!
        val set = ratingMap[originFood.cuisine]!!
        set.remove(originFood)
        originFood.rating = newRating
        set.add(originFood)
    }

    fun highestRated(cuisine: String): String {
        return ratingMap[cuisine]!!.first()!!.name
    }

}

data class Food(
    val name: String,
    val cuisine: String,
    var rating: Int
)