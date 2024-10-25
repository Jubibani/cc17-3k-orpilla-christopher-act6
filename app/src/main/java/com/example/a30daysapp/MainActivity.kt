package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.model.Day
import utilities.DayDataLoader

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dayAdapter: DayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create a static list of days
        val days = listOf(
            Day(1, "Discord Friends", R.drawable.dc.toString(),"A`brain rot before locking in` mechanic of mine is checking out my discord.",
            ),
            Day(2, "Blue screen of Death",    R.drawable.bluescreen_of_death.toString(),"I was playing and suddenly, blue screen of death greeted me. perhaps a sign to get back on the grind?",
            ),
            Day(3, "Blender Things", R.drawable.doing_blender.toString(), "I am making a game on the side so i thought it's good to also learn blender. very fun!"
            ),
            Day(4, "Arduino Class", R.drawable.doing_arduino.toString(), "I have a classmate who is very good at this subject! she knows her thang! sheesh, i should work hard and catch up!"
            ),
            Day(5, "Boring Class", R.drawable.class_day_w_friend.toString(), "I had a boring class and in the end, we didn't do anything. . . maybe being unproductive is sometimes good?"
            ),
            Day(6, "CSS Battle!", R.drawable.css_battle_w_classmates.toString(), "Our Instructor made us battle with css, whoever copies the reference accurately and as fast as possible wins, no cheating. but someone did so we all got 0, true story."
            ),
            Day(7, "Coding in Another World", R.drawable.coding_on_diff_dorm.toString(), "I had a power outbreak in my place while i had some activity to pass, so i asked a friend if he could let me in his dorm for 5 hours. in the end, we played together which resulted my submission late.  I had no regrets."
            ),
            Day(8, "Javascript", R.drawable.fcc_js.toString(), "Javascript sucks for finding errors, perhaps i'll try typescript next time? lol."
            ),
            Day(9, "Being Responsive", R.drawable.responsive_web_design.toString(), "Making a responsive web design in pure css makes my head hurt! if i fix that, i ruin the other. if i fix it again, i break the whole thing. this is too time consuming, i suggest adding libraries huhuhu."
            ),
            Day(10, "Certified Beginner", R.drawable.fcc_certificate.toString(), "It does not do much, but i have to admit that receiving this kind of certificate made my efforts worth it. I feel acknowledged."
            ),
            Day(11, "Best way to Learn is to Teach", R.drawable.content_programmer.toString(), "I decided to document how i code while i am explaining with english, for 1 month, I learned that I love sharing things that I learned to others."
            ),
            Day(12, "Errors are Lurking", R.drawable.fixing_git_error.toString(), "I tried to git clone a repo project that i made from home to a different PC, and i found a new error that i had not seen before. in the end, i solved it."
            ),
            Day(13, "I love Flutter!", R.drawable.flutter_project.toString(), "I wanted to learn App development, and so i did learn. I'm currently building this project with kotlin, but my first love was flutter. but we're no longer together."
            ),
            Day(14, "Trash Projects Game Development Edition", R.drawable.godot_projects.toString(), "Web development, App development, Now . . . I want Game Development. These are all thrash, but hey. I am learning from these as a stepping stone. and as long as i progress, i am fine with my projects being trash."
            ),
            Day(15, "Random Shot", R.drawable.godot_ins_panel.toString(), "I'm doing the coding challenge, this is just a random shot to show the evidence of it."
            ),
            Day(16, "How?", R.drawable.godot_line_count.toString(), "It didn't work. why? now, it works. why? I am confuse..very confused ungga bungga."
            ),
            Day(17, "i-it's my first time...kyah~", R.drawable.godot_asset.toString(), "I usually make 3D games because I don't like 2D games much, but hey, there's no hurting when we expose ourselves to the unknown, right? we only gain."
            ),
            Day(18, "Don't do long git commit, makapa sal it.", R.drawable.happy_git_commit.toString(), "I used to do Long Git commits and according to the internet, from the professional developers; it is not conventional as it will confuse other devs when git tracking."
            ),
            Day(19, "Learning from the Very Best", R.drawable.learning_from_best.toString(), "I had a class and i realized, that when learning from professionals, especially from the best. It inspires me to be like them and continue my endeavors."
            ),
            Day(20, "Eat your Frogs!", R.drawable.outdue_todo_lists.toString(), "Eat your biggest frog, if we deny. then we deny ourselves. essentially losing our belief on our selves, that's why we stress about our tasks then we get depressed."
            ),
            Day(21, "Hoodie Jackets are the batman suits of IT-CS students", R.drawable.outfitcheck_black_library.toString(), "I believe the title of this Day 21 to be true, but mine just went in for laundry so i'm sort of on a disguise. outfit check!"
            ),
            Day(22, "My money goes to my stomach", R.drawable.pampering_myself.toString(), "I worked hard for my school activities, and for my side projects. so i bought myself some food as a reward. it feels good when you treat yourself when you did good for yourself and not the way around it."
            ),
            Day(23, "Errors used to be scary, not Anymore!", R.drawable.powershell_selenium.toString(), "For me, when coding and building a project or an activity and then i get an error, i no longer get scared or stressed. getting an error now feels like a house chore that our parents ordered us before we continue our development."
            ),
            Day(24, "I didn't know debuggers exist!", R.drawable.powershell_errors.toString(), "I wish i knew about debuggers and how they worked when i was making this side project of mine. This was an automation project, it consumed lots of my time! i did more debugging than writing code for development."
            ),
            Day(25, "We're just Googling Experts", R.drawable.using_this_solution_git_error.toString(), "remember the git error? I eventually found the solution for the error i had!"
            ),
            Day(26, "Making a Side Project: Quickie", R.drawable.side_project_quickie.toString(), "Whether I go to class or learn from home, I have to open up and log in again to certain sites for my needed tools which is quite a hassle especially when going to school! —so I made `Quickie`."
            ),
            Day(27, "I am Speed", R.drawable.speedrunning_web_project.toString(), "This is a Web Development project that we were tasked to make a User Profile with animations and designs, i was not able to finish it on time because i procrastinated, i got 0 out of 100. What a bitter Lesson it was."
            ),
            Day(28, "How to React?", R.drawable.words_of_appreciation.toString(), "I know most of these cards are from dudes like me, but even so. i did not know how to handle these appreciations. but i did know that i was happy."
            ),
            Day(29, "Before we code, we eat", R.drawable.eating_mid_programming_session.toString(), "we are programmers, but we are not robots. we're still human. so i ate. . . .yes, it's unhealthy."
            ),
            Day(30, "BMO code", R.drawable.bmo_code.toString(), "I'm making a FreecodeCamp Certification project and dubbed it as BMO calculator, it has animations. and i had fun!"
            ),
        )

        // Set up the adapter
        dayAdapter = DayAdapter(days)
        recyclerView.adapter = dayAdapter

    }
}
