package uz.hamroh.home.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import uz.hamroh.trip.R
import uz.hamroh.ui.components.Section


@Composable
fun Profile() {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item { ProfileHeader(state) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item {
                Section(title = stringResource(R.string.section_main)) {
                    ProfileItem(
                        icon = uz.hamroh.ui.R.drawable.ic_contact_information_2,
                        title = stringResource(R.string.contact_information),
                        subtitle = stringResource(R.string.change_data),
                        onClicked = viewModel::onNavigateToContactInformation
                    )
                    ProfileItem(
                        icon = uz.hamroh.ui.R.drawable.ic_security_2,
                        title = stringResource(R.string.security),
                        subtitle = stringResource(R.string.password_email),
                        onClicked = viewModel::onNavigateToSecurity
                    )
                    ProfileItem(
                        icon = uz.hamroh.ui.R.drawable.ic_payment,
                        title = stringResource(R.string.payment_methods),
                        subtitle = stringResource(R.string.link_card),
                        onClicked = viewModel::onNavigateToPayment
                    )
                    ProfileItem(
                        icon =uz.hamroh.ui.R.drawable.ic_terms,
                        title = stringResource(R.string.terms_of_use),
                        subtitle = stringResource(R.string.terms_of_use_subtitle),
                        onClicked = { }
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item {
                Section(title = stringResource(R.string.section_settings)) {
                    ProfileItem(
                        icon =uz.hamroh.ui.R.drawable.ic_car,
                        title = stringResource(R.string.my_cars),
                        subtitle = stringResource(R.string.add_vehicle),
                        onClicked = viewModel::onNavigateToCars
                    )
                    ProfileItem(
                        icon = uz.hamroh.ui.R.drawable.ic_documents_24,
                        title = stringResource(R.string.my_documents),
                        subtitle = stringResource(R.string.documents_subtitle),
                        onClicked = viewModel::onNavigateToDocuments
                    )
                    ProfileItem(
                        icon = uz.hamroh.ui.R.drawable.ic_logout,
                        title = stringResource(R.string.exit),
                        subtitle = stringResource(id = R.string.exit_description),
                        onClicked = viewModel::onLogout
                    )
                }
            }
        }
    }
}


@Composable
fun ProfileHeader(state: ProfileState) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(state.iconUrl)
                .crossfade(true)
                .build(),
            fallback = painterResource(R.drawable.profile_avatar_placeholder_large),
            error = painterResource(R.drawable.profile_avatar_placeholder_large),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(state.email, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(stringResource(id = R.string.profile_description), color = Color.Gray)
        }
    }
}



@Composable
fun ProfileItem(icon: Int, title: String, subtitle: String, onClicked: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClicked() }
            .padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(title, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(subtitle, color = Color.Gray)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = uz.hamroh.ui.R.drawable.ic_chevron_right),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}
