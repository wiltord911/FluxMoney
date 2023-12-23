package com.avatarcode.fluxmoney.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.sharp.DateRange
import androidx.compose.material.icons.sharp.ExitToApp
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avatarcode.fluxmoney.ui.domain.BottomNav
import com.avatarcode.fluxmoney.ui.domain.Transaction
import com.avatarcode.fluxmoney.ui.theme.ContainairItemBacground
import java.time.LocalDate
import java.util.Date

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    // topApBar
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            navBar()
        }
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(it)
        ) {
            cardSection()
            recenTransation()
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

    TopAppBar(

{
            CenterAlignedTopAppBar(
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 25.sp,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                ) {
                                    append("Welcome,")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 25.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("wiltord")
                                }

                            }
                        )
                        Text(
                            text = "Good morning",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                })
        },
        modifier = Modifier
            .padding(20.dp)
            .background(Color.White)
        ,
        navigationIcon = {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Black)

            ) {
                IconButton(onClick = { /*TODO*/ }) {
                }
            }
        },
        actions = {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu",
                    tint = Color.Black,

                    )
            }

        }
    )
}


@Composable
fun recenTransation() {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recent Transactions",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "View All",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            val width = this.maxWidth / 3
            LazyColumn() {
                items(3) { index ->
                    TransationItem(index, width)
                }
            }
        }

    }

}


@Composable
fun TransationItem(index: Int, width: Dp) {

    val item = datas[index]

    val rotation by remember {
        mutableStateOf(if (item.statut == "received") 90f else -90f)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                //.width(width = width)

        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(50.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center

            ) {
                Icon(
                    modifier = Modifier
                        .rotate(rotation)
                        .size(18.dp),
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color.White

                )
            }
        }

        Column(
            modifier = Modifier.
                weight(2f),
           // width(width = width),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = item.userName,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(text = "${item.date}",
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontSize = 13.sp)
        }

        Column(
            modifier = Modifier
                .weight(2f),
                //.width(width = width),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$${item.amount}",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontSize = 15.sp
            )
            Text(
                text = item.statut,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                fontSize = 14.sp
            )
        }

    }
    if (index != 2) {
        Spacer(modifier = Modifier.height(10.dp))
        Divider(modifier = Modifier.alpha(0.9f))
    }
    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun navBar() {


    var selectedindex by remember {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White

    ) {

        Row() {
            navViews.forEachIndexed { index, bottomNav ->
                NavigationBarItem(
                    selected = index == selectedindex,
                    onClick = { selectedindex = index },
                    icon = {
                        Icon(
                            modifier =  Modifier.size(25.dp),
                            imageVector =  bottomNav.icon,
                            contentDescription = bottomNav.title,
                            tint = Color.Black ,

                        )
                    },
                    label = {
                            Text(
                                text = bottomNav.title,
                                color = Color.Black
                            )

                    },
                    alwaysShowLabel = false,
                    colors =NavigationBarItemDefaults.colors(
                        indicatorColor = ContainairItemBacground
                    )
                )
            }
        }

    }

}

@Composable
fun cardSection() {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Black)
    ) {

        Row(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 12.dp,
                    end = 18.dp,
                )
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Rounded.ExitToApp,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background,
                    modifier = Modifier.size(50.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Balance",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.background
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "$4320.000",
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.weight(6f)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colorScheme.background,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("v")
                            }
                            withStyle(
                                SpanStyle(
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colorScheme.background,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("isa")
                            }

                        },
                        modifier = Modifier.weight(1f)

                    )
                }

            }


        }


    }
}


val navViews = listOf(
    BottomNav(
        "Home",
        Icons.Outlined.Home
    ),

    BottomNav(
        "Transaction",
        Icons.Outlined.Build
    ),

    BottomNav(
        "Ranger",
        Icons.Outlined.DateRange
    ),

    BottomNav(
        "profil",
        Icons.Outlined.Person
    )
)

val datas = listOf(

    Transaction(
        userName = "wiltord",
        amount = 150.0,
        date = LocalDate.now(),
        statut = "received"
    ), Transaction(
        userName = "patrick",
        amount = 250.0,
        date = LocalDate.now(),
        statut = "send"
    ),
    Transaction(
        userName = "kevine",
        amount = 400.0,
        date = LocalDate.now(),
        statut = "send"
    ),
    Transaction(
        userName = "jonathan",
        amount = 300.0,
        date = LocalDate.now(),
        statut = "received"
    ),
    Transaction(
        userName = "pedro",
        amount = 300.0,
        date = LocalDate.now(),
        statut = "send"
    )
)

