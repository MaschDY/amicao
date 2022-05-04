package br.com.maschdy.amicao.data

import br.com.maschdy.amicao.R
import br.com.maschdy.amicao.data.model.Buddy

object DataProvider {
    val buddy =
        Buddy(
            id = 1,
            name = "Monty",
            sex = "Male",
            age = 14,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            buddyImageId = R.drawable.p1
        )

    val buddyList = listOf(
        buddy,
        Buddy(
            id = 2,
            name = "Jubilee",
            sex = "Female",
            age = 6,
            description = "Jubilee enjoys thoughtful discussions by the campfire.",
            buddyImageId = R.drawable.p2
        ),
        Buddy(
            id = 3,
            name = "Beezy",
            sex = "Male",
            age = 8,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            buddyImageId = R.drawable.p3
        ),
        Buddy(
            id = 4,
            name = "Mochi",
            sex = "Male",
            age = 10,
            description = "Mochi is the perfect \"rubbery ducky\" debugging pup, always listening.",
            buddyImageId = R.drawable.p4
        ),
        Buddy(
            id = 5,
            name = "Brewery",
            sex = "Female",
            age = 12,
            description = "Brewery loves fetching you your favorite homebrew.",
            buddyImageId = R.drawable.p5
        ),
        Buddy(
            id = 6,
            name = "Lucy",
            sex = "Female",
            age = 8,
            description = "Picture yourself in a boat on a river, Lucy is a pup with kaleidoscope eyes.",
            buddyImageId = R.drawable.p6
        ),
        Buddy(
            id = 7,
            name = "Astro",
            sex = "Male",
            age = 10,
            description = "Is it a bird? A plane? No, it's Astro blasting off into your heart!",
            buddyImageId = R.drawable.p7
        ),
        Buddy(
            id = 8,
            name = "Boo",
            sex = "Female",
            age = 9,
            description = "Boo is just a teddy bear in disguise. What he lacks in grace, he makes up in charm.",
            buddyImageId = R.drawable.p8
        ),
        Buddy(
            id = 9,
            name = "Pippa",
            sex = "Male",
            age = 7,
            description = "Pippa likes to look out the window and write pup-poetry.",
            buddyImageId = R.drawable.p9
        ),
        Buddy(
            id = 10,
            name = "Coco",
            sex = "Female",
            age = 10,
            description = "Coco enjoys getting pampered at the local puppy spa.",
            buddyImageId = R.drawable.p10
        ),
        Buddy(
            id = 11,
            name = "Brody",
            sex = "Male",
            age = 13,
            description = "Brody is a good boy, waiting for your next command.",
            buddyImageId = R.drawable.p11
        ),
        Buddy(
            id = 12,
            name = "Stella",
            sex = "Female",
            age = 14,
            description = "Stella! Calm and always up for a challenge, she's the perfect companion.",
            buddyImageId = R.drawable.p12
        ),
    )
}