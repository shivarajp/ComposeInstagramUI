import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shivaraj.instagramui.ImageWithText
import com.shivaraj.instagramui.R

@Composable
fun ProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(
            name = "shivarajpatil",
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProfileSection()
        PostTabsSection(
            posts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostsSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}


@Composable
fun TopBar(
    name: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = name,
            modifier = Modifier
                .padding(2.dp),
            color = Color.Black,
            fontWeight = Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "back",
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "back",
            modifier = Modifier.size(20.dp)
        )
    }
}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.master_logical_thinking),
                contentDescription = "profile",
                modifier = modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .padding(3.dp)
                    .clip(CircleShape)
                    .weight(3f)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(7f)
            ) {
                ProfileStat(number = "501", label = "Posts")
                ProfileStat(number = "100k", label = "Followers")
                ProfileStat(number = "111", label = "Following")
            }

        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(16.dp)
        ) {

            Text(
                text = "Shivaraj Patil",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = Bold
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Welcome to my channel \n" +
                        "I make tech related videos \n" +
                        "Do consider following my channel\n" +
                        "Thanks for visiting my channel",
                color = Color.Black,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Followed by Shiv & 20 others",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = Bold
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Following",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(4.dp)

                    )
                    .padding(4.dp)
            )
            Text(
                text = "Message",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(4.dp)

                    )
                    .padding(4.dp)
            )
            Text(
                text = "Email",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(4.dp)

                    )
                    .padding(4.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "down",
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(4.dp)

                    )
                    .padding(4.dp)
            )
        }
    }
}


@Composable
fun ProfileStat(
    number: String,
    label: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = number,
            color = Color.Black,
            fontWeight = Bold,
            fontSize = 20.sp
        )
        Text(
            text = label,
            color = Color.Black,
            fontSize = 14.sp
        )
    }
}

@Composable
fun PostTabsSection(
    posts: List<ImageWithText>,
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {

        posts.forEachIndexed { index, item ->

            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostsSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }

}

