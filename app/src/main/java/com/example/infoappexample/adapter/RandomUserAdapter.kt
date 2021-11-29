package com.example.infoappexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infoappexample.R
import com.example.infoappexample.databinding.*
import com.example.infoappexample.model.InfoResponse

class RandomUserAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var  randomUserInfo: InfoResponse
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BASIC_INFO -> {
                BasicInfoViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.basic_info_layout, parent, false))
            }
            CONTACT_INFO -> {
                ContactInfoViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.contact_info_layout, parent, false))
            }
            ADDRESS -> {
                AddressViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.address_layout, parent, false))
            }
            LOGIN_CREDENTIALS_INFO -> {
                LoginCredentialsInfoViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.login_credentials_info, parent, false))
            }
            ABOUT_ACCOUNT -> {
                AboutAccountViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.about_account_layout, parent, false))
            }
            else -> {
                BasicInfoViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.basic_info_layout, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BasicInfoViewHolder -> {
                holder.bindBasicInfo(randomUserInfo)
            }
            is ContactInfoViewHolder -> {
                holder.bindContactInfo(randomUserInfo)
            }
            is AddressViewHolder -> {
                holder.bindAddress(randomUserInfo)
            }
            is LoginCredentialsInfoViewHolder -> {
                holder.bindLoginCredentialsInfo(randomUserInfo)
            }
            is AboutAccountViewHolder -> {
                holder.bindAboutAccount(randomUserInfo)
            }
        }
    }

    override fun getItemCount(): Int = 5

    override fun getItemViewType(position: Int) = position

    fun submitRandomUserInfo(infoResponse: InfoResponse){
        randomUserInfo = infoResponse
        notifyDataSetChanged()
    }

    inner class BasicInfoViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        private val basicInfoLayoutBinding = BasicInfoLayoutBinding.bind(v)
        fun bindBasicInfo(randomUserInfo: InfoResponse) = with(basicInfoLayoutBinding) {
            randomUserInfo.results.firstOrNull()?.let {
                tittle.text = it.name.tittle
                fullName.text = it.name.firstName.plus(" ").plus(it.name.lastName)
                gender.text = it.gender
                age.text = it.dob.age.toString()
                nat.text = it.nat
                dateOfBirth.text = it.dob.date
            }
        }
    }

    inner class ContactInfoViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        private val contactInfoLayoutBinding = ContactInfoLayoutBinding.bind(v)
        fun bindContactInfo(randomUserInfo: InfoResponse) = with(contactInfoLayoutBinding){
            randomUserInfo.results.firstOrNull()?.let {
                email.text = it.email
                phone.text = it.phone
                cell.text = it.cell
            }
        }
    }

    inner class AddressViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        private val addressLayoutBinding = AddressLayoutBinding.bind(v)
        fun bindAddress(randomUserInfo: InfoResponse) = with(addressLayoutBinding){
            randomUserInfo.results.firstOrNull()?.let {
                country.text = it.location.country
                state.text = it.location.state
                city.text = it.location.city
                street.text = it.location.street.name.plus(" ").plus(it.location.street.number)
                zipCode.text = it.location.postCode
                latitude.text = it.location.coordinates.latitude
                longitude.text = it.location.coordinates.longitude
                offset.text = it.location.timezone.offset
                description.text = it.location.timezone.description
            }
        }
    }

    inner class LoginCredentialsInfoViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        private val loginCredentialsInfoLayoutBinding = LoginCredentialsInfoBinding.bind(v)
        fun bindLoginCredentialsInfo(randomUserInfo: InfoResponse) = with(loginCredentialsInfoLayoutBinding){
            randomUserInfo.results.firstOrNull()?.let {
                uuid.text = it.login.uuid
                userName.text = it.login.userName
                password.text = it.login.password
                salt.text = it.login.salt
                md5.text = it.login.md5
                sha1.text = it.login.sha1
                sha256.text = it.login.sha256
            }
        }
    }

    inner class AboutAccountViewHolder constructor(v: View) : RecyclerView.ViewHolder(v) {
        private val aboutAccountLayoutBinding = AboutAccountLayoutBinding.bind(v)
        fun bindAboutAccount(randomUserInfo: InfoResponse) = with(aboutAccountLayoutBinding){
            randomUserInfo.results.firstOrNull()?.let {
                id.text = it.id.name
                value.text = it.id.value
                dateOfCreation.text = it.registered.date
                ageOfCreation.text = it.registered.age.toString()
            }
        }
    }

    companion object {
        private const val BASIC_INFO = 0
        private const val CONTACT_INFO = 1
        private const val ADDRESS = 2
        private const val LOGIN_CREDENTIALS_INFO = 3
        private const val ABOUT_ACCOUNT = 4
    }
}