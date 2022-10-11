/**
 Time complexity of funcion getNewsFeed() is O(log(n))
 n = count of followee followed by input user

 Space : O(count of posts) and O(times of function follow() called)
 */
class Twitter() {
    // follow map
    val map = mutableMapOf<Int, MutableSet<Int>>()
    // posts map
    val posts = mutableMapOf<Int, MutableList<Post>>()
    // timestamp of posts
    var time = 0

    fun postTweet(userId: Int, tweetId: Int) {
        posts[userId] = (posts[userId] ?: mutableListOf()).apply {
            add(0, Post(time, tweetId))
        }
        time++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val queue = PriorityQueue<Post>(compareByDescending { it.time })
        posts[userId]?.let {
            addIntoQueue(it, queue)
        }

        map[userId]?.let { followeeSet ->
            followeeSet.forEach { f ->
                posts[f]?.let {
                    addIntoQueue(it, queue)
                }
            }
        }

        val res = mutableListOf<Int>()
        var count = 0
        while (queue.isNotEmpty() && count < 10) {
            res.add(queue.poll()!!.tweetId)
            count++
        }
        return res
    }

    private fun addIntoQueue(list: List<Post>, queue: PriorityQueue<Post>) {
        var count = 0
        for (p in list) {
            if (count >= 10) break
            queue.add(p)
            count++
        }
    }

    fun follow(followerId: Int, followeeId: Int) {
        map[followerId] = (map[followerId] ?: mutableSetOf()).apply {
            add(followeeId)
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        map[followerId]?.apply {
            remove(followeeId)
        }
    }

    data class Post(
        val time: Int,
        val tweetId: Int
    )
}
