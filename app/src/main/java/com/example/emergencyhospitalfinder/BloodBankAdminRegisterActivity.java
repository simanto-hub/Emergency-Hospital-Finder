package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class BloodBankAdminRegisterActivity extends AppCompatActivity {

    TextView registered;
    EditText t1,t2,t3,t4,t5,t6,t7;
    Button sign_up_btn;

    Spinner sp_district,sp_thana;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_admin_register);

        sign_up_btn =findViewById(R.id.sign_up_btn);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);

        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sp_district = findViewById(R.id.sp_district);
        sp_thana = findViewById(R.id.sp_thana);

        List<String> District = new ArrayList<>();
        District.add(0,"Select District");

        District.add("Dhaka"); District.add("Faridpur"); District.add("Madaripur"); District.add("Gazipur"); District.add("Gopalganj");
        District.add("Kishoreganj");  District.add("Manikganj");  District.add("Munshiganj"); District.add("Naryanganj");
        District.add("Narsingdi");  District.add("Rajbari");  District.add("Shariatpur"); District.add("Tangai");

        District.add("Barisal");District.add("Barguna"); District.add("Bhola"); District.add("Jhalokati"); District.add("Patuakhali");
        District.add("Pirojpur");

        District.add("Chattogram");  District.add("Bandarban"); District.add("Brahmanbaria"); District.add("Chandpur");  District.add("Comilla");
        District.add("Cox's Bazar"); District.add("Feni"); District.add("Khagrachhari");  District.add("Lakshmipur"); District.add("Noakhali");
        District.add("Rangamati");

        District.add("Khulna");  District.add("Bagerhat"); District.add("Chuadanga"); District.add("Jessore");  District.add("Jhenaidah"); District.add("Kushtia");
        District.add("Magura");  District.add("Meherpur");  District.add("Narail"); District.add("Satkhira");

        District.add("Rajshahi");  District.add("Bogra"); District.add("Joypurhat"); District.add("Naogaon");  District.add("Natore"); District.add("Nawabganj");
        District.add("Pabna");  District.add("Sirajgan");

        District.add("Rangpur");  District.add("Dinajpur"); District.add("Gaibandha"); District.add("Kurigram");  District.add("Lalmanirhat "); District.add("Nilphamari");
        District.add("Panchagarh");  District.add("Thakurgaon");

        District.add("Sylhet");  District.add("Habiganj"); District.add("Moulvibazar"); District.add("Sunamganj");

        District.add("Mymensingh");  District.add("Jamalpur "); District.add("Netrakona"); District.add("Sherpur");


        /*======Dhaka=====*/

        final List<String> Dhaka = new ArrayList<>();
        Dhaka.add(0,"Select Thana");
        Dhaka.add("Adabor");      Dhaka.add("Airport");      Dhaka.add("Badda ");           Dhaka.add("Banani");      Dhaka.add("Bangshal ");      Dhaka.add("Bhashantek"); Dhaka.add("Cantonment");  Dhaka.add("Chackbazar");
        Dhaka.add("Darussalam");  Dhaka.add("Daskhinkhan");  Dhaka.add("Demra");            Dhaka.add("Dhamrai");     Dhaka.add("Dhanmondi");      Dhaka.add("Dohar");      Dhaka.add("Gandaria");    Dhaka.add("Gulshan");
        Dhaka.add("Hazaribag");   Dhaka.add("Jatrabari");    Dhaka.add("Kafrul");           Dhaka.add("Kalabagan");   Dhaka.add("Kamrangirchar");  Dhaka.add("Keraniganj"); Dhaka.add("Khilgaon");    Dhaka.add("Khilkhet");
        Dhaka.add("Kotwali");     Dhaka.add("Lalbag");       Dhaka.add("Mirpur Model");     Dhaka.add("Mohammadpur"); Dhaka.add("Motijheel");      Dhaka.add("Mugda");      Dhaka.add("Nawabganj");   Dhaka.add("New Market");
        Dhaka.add("Pallabi");     Dhaka.add("Paltan");       Dhaka.add("Ramna");            Dhaka.add("Rampura");     Dhaka.add("Rupnagar");       Dhaka.add("Sabujbag");   Dhaka.add("Savar");       Dhaka.add("Shah Ali");
        Dhaka.add("Shahbag");     Dhaka.add("Shahjahanpur"); Dhaka.add("Sherebanglanagar"); Dhaka.add("Shyampur");    Dhaka.add("Sutrapur");       Dhaka.add("Tejgaon");    Dhaka.add("Tejgaon I/A"); Dhaka.add("Turag");
        Dhaka.add("Uttara");      Dhaka.add("Uttara West");  Dhaka.add("Uttarkhan");        Dhaka.add("Vatara");      Dhaka.add("Wari");


        final List<String> Faridpur = new ArrayList<>();
        Faridpur.add(0,"Select Thana");
        Faridpur.add("Faridpur Sadar");  Faridpur.add("Boalmari");     Faridpur.add("Alfadanga");       Faridpur.add("Madhukhali");
        Faridpur.add("Bhanga");          Faridpur.add("Nagarkanda");   Faridpur.add("Charbhadrasan");   Faridpur.add("Sadarpur");
        Faridpur.add("Shaltha");

        final List<String> Gazipur  = new ArrayList<>();
        Gazipur.add(0,"Select Thana");
        Gazipur.add("Gazipur Sadar");    Gazipur.add("Kaliakior");     Gazipur.add("Kapasia");          Gazipur.add("Sripur");      Gazipur.add("Kaliganj");  Gazipur.add("Tongi");

        final List<String> Gopalganj = new ArrayList<>();
        Gopalganj.add(0,"Select Thana");
        Gopalganj.add("Gopalganj Sadar");  Gopalganj.add("Kashiani");  Gopalganj.add("Kotalipara");  Gopalganj.add("Muksudpur");    Gopalganj.add("Tungipara");

        final List<String> Kishoreganj= new ArrayList<>();
        Kishoreganj.add(0,"Select Thana");
        Kishoreganj.add("Astagram");  Kishoreganj.add("Bajitpur");     Kishoreganj.add("Bhairab");            Kishoreganj.add("Hossainpur");   Kishoreganj.add("Itna");
        Kishoreganj.add("Karimganj"); Kishoreganj.add("Katiadi");      Kishoreganj.add("Kishoreganj Sadar");  Kishoreganj.add("Kuliarchar");   Kishoreganj.add("Mithamain");
        Kishoreganj.add("Nikli ");    Kishoreganj.add("Pakundia");     Kishoreganj.add("Tarail");

        final List<String> Madaripur =new ArrayList<>();
        Madaripur.add(0,"Select Thana");
        Madaripur.add("Madaripur Sadar");  Madaripur.add("Kalkini");  Madaripur.add("Rajoir");  Madaripur.add("Shibchar");

        final List<String> Manikganj =new ArrayList<>();
        Manikganj.add(0,"Select Thana");
        Manikganj.add("Manikganj Sadar"); Manikganj.add("Singair"); Manikganj.add("Shibalaya"); Manikganj.add("Saturia"); Manikganj.add("Harirampur");
        Manikganj.add("Ghior"); Manikganj.add("Daulatpur");

        final List<String> Munshiganj =new ArrayList<>();
        Munshiganj.add(0,"Select Thana");
        Munshiganj.add("Lohajang"); Munshiganj.add("Sreenagar"); Munshiganj.add("Munshiganj Sadar"); Munshiganj.add("Sirajdikhan"); Munshiganj.add("Tongibari");
        Munshiganj.add("Gazaria");

        final List<String> Naryanganj =new ArrayList<>();
        Naryanganj.add(0,"Select Thana");
        Naryanganj.add("Naryanganj Sadar");  Naryanganj.add("Araihazar");  Naryanganj.add("Sonargaon");  Naryanganj.add("Bandar");  Naryanganj.add("Rupganj");
        Naryanganj.add("Siddirgonj");

        final List<String> Narsingdi =new ArrayList<>();
        Narsingdi.add(0,"Select Thana");
        Narsingdi.add("Narsingdi Sadar"); Narsingdi.add("Belabo"); Narsingdi.add("Monohardi");  Narsingdi.add("Palash"); Narsingdi.add("Raipura");
        Narsingdi.add("Shibpur");

        final List<String> Rajbari =new ArrayList<>();
        Rajbari.add(0,"Select Thana");
        Rajbari.add("Rajbari Sadar"); Rajbari.add("Baliakandi"); Rajbari.add("Goalandaghat"); Rajbari.add("Pangsha"); Rajbari.add("Kalukhali");

        final List<String> Shariatpur =new ArrayList<>();
        Shariatpur.add(0,"Select Thana");
        Shariatpur.add("Shariatpur Sadar"); Shariatpur.add("Damudya");  Shariatpur.add("Naria");  Shariatpur.add("Jajira");
        Shariatpur.add("Bhedarganj");  Shariatpur.add("Gosairhat");

        final List<String> Tangail =new ArrayList<>();
        Tangail.add(0,"Select Thana");
        Tangail.add("Tangail Sadar"); Tangail.add("Sakhipur"); Tangail.add("Basail"); Tangail.add("Madhupur"); Tangail.add("Ghatail");
        Tangail.add("Kalihati"); Tangail.add("Nagarpur"); Tangail.add("Mirzapur"); Tangail.add("Gopalpur"); Tangail.add("Delduar");
        Tangail.add("Bhuapur"); Tangail.add("Dhanbari");


        /*======Barisal=====*/

        final List<String> Barisal=new ArrayList<>();
        Barisal.add(0,"Select Thana");
        Barisal.add("Muladi");   Barisal.add("Babuganj"); Barisal.add("Agailjhara");  Barisal.add("Barisal Sadar");  Barisal.add("Bakerganj");
        Barisal.add("Banaripara");   Barisal.add("Gaurnadi"); Barisal.add("Hizla");  Barisal.add("Mehendiganj");  Barisal.add("Wazirpur");
        Barisal.add("Airport ");  Barisal.add("Kawnia");  Barisal.add("Bondor");

        final List<String> Barguna=new ArrayList<>();
        Barguna.add(0,"Select Thana");
        Barguna.add("Amtali"); Barguna.add("Bamna");  Barguna.add("Barguna Sadar");  Barguna.add("Betagi");  Barguna.add("Patharghata");
        Barguna.add("Taltali");

        final List<String> Bhola=new ArrayList<>();
        Bhola.add(0,"Select Thana");
        Bhola.add("Bhola Sadar");  Bhola.add("Burhanuddin");  Bhola.add("Char Fasson");  Bhola.add("Daulatkhan");  Bhola.add("Lalmohan");
        Bhola.add("Manpura");  Bhola.add("Tazumuddin");

        final List<String> Jhalokati=new ArrayList<>();
        Jhalokati.add(0,"Select Thana");
        Jhalokati.add("Jhalokati Sadar"); Jhalokati.add("Kathalia"); Jhalokati.add("Nalchity"); Jhalokati.add("Rajapur");

        final List<String> Patuakhali=new ArrayList<>();
        Patuakhali.add(0,"Select Thana");
        Patuakhali.add("Patuakhali Sadar"); Patuakhali.add("Bauphal"); Patuakhali.add("Dashmina"); Patuakhali.add("Galachipa");
        Patuakhali.add("Kalapara"); Patuakhali.add("Mirzaganj"); Patuakhali.add("Dumki");
        Patuakhali.add("Rangabali");

        final List<String> Pirojpur=new ArrayList<>();
        Pirojpur.add(0,"Select Thana");
        Pirojpur.add("Bhandaria"); Pirojpur.add("Kaukhali"); Pirojpur.add("Mathbaria"); Pirojpur.add("Nazirpur"); Pirojpur.add("Nesarabad");
        Pirojpur.add("Pirojpur Sadar"); Pirojpur.add("Zianagar");


        /*======Chattogram=====*/

        final List<String> Chattogram=new ArrayList<>();
        Chattogram.add(0,"Select Thana");
        Chattogram.add("Anwara");  Chattogram.add("Banshkhali");  Chattogram.add("Boalkhali");  Chattogram.add("Chandanaish"); Chattogram.add("Fatikchhari");
        Chattogram.add("Hathazari");  Chattogram.add("Lohagara");  Chattogram.add("Mirsharai");  Chattogram.add("Patiya");  Chattogram.add("Rangunia");
        Chattogram.add("Raozan");  Chattogram.add("Sandwip");  Chattogram.add("Satkania");  Chattogram.add("Sitakunda");  Chattogram.add("Akborsha");
        Chattogram.add("Baijid Bostami");  Chattogram.add("Bakolia");  Chattogram.add("Bandar");  Chattogram.add("Chandgaon");  Chattogram.add("Chokbazar");
        Chattogram.add("Doublemooring");  Chattogram.add("EPZ");  Chattogram.add("Hali Shohor");  Chattogram.add("Kornafuli");  Chattogram.add("Kotwali");
        Chattogram.add("Kulshi");  Chattogram.add("Pahartali");  Chattogram.add("Panchlaish");  Chattogram.add("Potenga");  Chattogram.add("Shodhorgat");

        final List<String> Bandarban=new ArrayList<>();
        Bandarban.add(0,"Select Thana");
        Bandarban.add("Bandarban Sadar"); Bandarban.add("Thanchi");  Bandarban.add("Lama"); Bandarban.add("Naikhongchhari");
        Bandarban.add("Ali kadam"); Bandarban.add("Rowangchhari");   Bandarban.add("Ruma");

        final List<String> Brahmanbaria=new ArrayList<>();
        Brahmanbaria.add(0,"Select Thana");
        Brahmanbaria.add("Brahmanbaria Sadar");  Brahmanbaria.add("Ashuganj");  Brahmanbaria.add("Nasirnagar");  Brahmanbaria.add("Nabinagar");
        Brahmanbaria.add("Sarail");  Brahmanbaria.add("Shahbazpur Town");  Brahmanbaria.add("Kasba");  Brahmanbaria.add("Akhaura");
        Brahmanbaria.add("Bancharampur");  Brahmanbaria.add("Bijoynagar");

        final List<String>   Chandpur=new ArrayList<>();
        Chandpur.add(0,"Select Thana");
        Chandpur.add("Chandpur Sadar");  Chandpur.add("Faridganj");  Chandpur.add("Haimchar");  Chandpur.add("Haziganj");
        Chandpur.add("Kachua");  Chandpur.add("Matlab Uttar"); Chandpur.add("Matlab Dakkhin");  Chandpur.add("Shahrasti");

        final List<String>   Comilla=new ArrayList<>();
        Comilla.add(0,"Select Thana");
        Comilla.add("Barura");  Comilla.add("Brahmanpara"); Comilla.add("Burichong"); Comilla.add("Chandina"); Comilla.add("Chauddagram");
        Comilla.add("Daudkandi");  Comilla.add("Debidwar");  Comilla.add("Homna");  Comilla.add("Comilla Sadar"); Comilla.add("Laksam");
        Comilla.add("Monohorgonj"); Comilla.add("Meghna");  Comilla.add("Muradnagar");  Comilla.add("Nangalkot");  Comilla.add("Comilla Sadar South");
        Comilla.add("Titas");

        final List<String>   CoxsBazar =new ArrayList<>();
        CoxsBazar.add(0,"Select Thana");
        CoxsBazar.add("Chakaria");  CoxsBazar.add("Cox's Bazar Sadar");  CoxsBazar.add("Kutubdia");  CoxsBazar.add("Maheshkhali");  CoxsBazar.add("Ramu");
        CoxsBazar.add("Teknaf");  CoxsBazar.add("Ukhia");  CoxsBazar.add("Pekua");

        final List<String>  Feni =new ArrayList<>();
        Feni.add(0,"Select Thana");
        Feni.add("Feni Sadar"); Feni.add("Chagalnaiya"); Feni.add("Daganbhyan"); Feni.add("Parshuram");
        Feni.add("Fhulgazi"); Feni.add("Sonagazi");

        final List<String>  Khagrachhari =new ArrayList<>();
        Khagrachhari.add(0,"Select Thana");
        Khagrachhari.add("Dighinala"); Khagrachhari.add("Khagrachhari"); Khagrachhari.add("Lakshmichhari"); Khagrachhari.add("Mahalchhari");
        Khagrachhari.add("Manikchhari"); Khagrachhari.add("Matiranga"); Khagrachhari.add("Panchhari"); Khagrachhari.add("Ramgarh");

        final List<String>  Lakshmipur =new ArrayList<>();
        Lakshmipur.add(0,"Select Thana");
        Lakshmipur.add("Lakshmipur Sadar"); Lakshmipur.add("Raipur"); Lakshmipur.add("Ramganj"); Lakshmipur.add("Ramgati ");
        Lakshmipur.add("Komol Nagar");

        final List<String>  Noakhali  =new ArrayList<>();
        Noakhali.add(0,"Select Thana");
        Noakhali.add("Noakhali Sadar");  Noakhali.add("Begumganj");  Noakhali.add("Chatkhil");  Noakhali.add("Companyganj");  Noakhali.add("Shenbag");
        Noakhali.add("Hatia");  Noakhali.add("Kobirhat");  Noakhali.add("Sonaimuri");  Noakhali.add("Suborno Char");

        final List<String> Rangamati  =new ArrayList<>();
        Rangamati.add(0,"Select Thana");
        Rangamati.add("Rangamati Sadar");   Rangamati.add("Belaichhari");  Rangamati.add("Bagaichhari");  Rangamati.add("Barkal");  Rangamati.add("Juraichhari");
        Rangamati.add("Rajasthali");  Rangamati.add("Kaptai");  Rangamati.add("Langadu");  Rangamati.add("Nannerchar");  Rangamati.add("Kaukhali");



        /*======Khulna=====*/

        final List<String> Khulna  =new ArrayList<>();
        Khulna.add(0,"Select Thana");
        Khulna.add("Terokhada"); Khulna.add("Batiaghata"); Khulna.add("Dacope"); Khulna.add("Dumuria"); Khulna.add("Dighalia ");
        Khulna.add("Koyra"); Khulna.add("Paikgachha"); Khulna.add("Phultala"); Khulna.add("Rupsa"); Khulna.add("Aranghata");
        Khulna.add("Daulatpur"); Khulna.add("Harintana"); Khulna.add("Horintana"); Khulna.add("Khalishpur"); Khulna.add("Khanjahan Ali");
        Khulna.add("Khulna Sadar"); Khulna.add("Labanchora"); Khulna.add("Sonadanga");

        final List<String>Bagerhat  =new ArrayList<>();
        Bagerhat.add(0,"Select Thana");
        Bagerhat.add("Bagerhat Sadar"); Bagerhat.add("Chitalmari"); Bagerhat.add("Fakirhat"); Bagerhat.add("Kachua"); Bagerhat.add("Mollahat");
        Bagerhat.add("Mongla"); Bagerhat.add("Morrelganj"); Bagerhat.add("Rampal"); Bagerhat.add("Sarankhola");

        final List<String>Chuadanga =new ArrayList<>();
        Chuadanga.add(0,"Select Thana");
        Chuadanga.add("Chuadanga Sadar");  Chuadanga.add("Damurhuda"); Chuadanga.add("Jibannagar");  Chuadanga.add("Alamdanga");

        final List<String>Jessore =new ArrayList<>();
        Jessore.add(0,"Select Thana");
        Jessore.add("Abhaynagar"); Jessore.add("Keshabpur"); Jessore.add("Bagherpara"); Jessore.add("Jessore Sadar");
        Jessore.add("Chaugachha"); Jessore.add("Manirampur"); Jessore.add("Jhikargachha"); Jessore.add("Sharsha");

        final List<String>Jhenaidah =new ArrayList<>();
        Jhenaidah.add(0,"Select Thana");
        Jhenaidah.add("Jhenaidah Sadar"); Jhenaidah.add("Maheshpur"); Jhenaidah.add("Kaliganj"); Jhenaidah.add("Kotchandpur");
        Jhenaidah.add("Shailkupa"); Jhenaidah.add("Harinakunda");

        final List<String>Kushtia =new ArrayList<>();
        Kushtia.add(0,"Select Thana");
        Kushtia.add("Kushtia Sadar"); Kushtia.add("Kumarkhali"); Kushtia.add("Daulatpur"); Kushtia.add("Mirpur");
        Kushtia.add("Bheramara"); Kushtia.add("Khoksa");

        final List<String>Magura =new ArrayList<>();
        Magura.add(0,"Select Thana");
        Magura.add("Magura Sadar"); Magura.add("Mohammadpur"); Magura.add("Shalikha"); Magura.add("Sreepur");

        final List<String>Meherpur =new ArrayList<>();
        Meherpur.add(0,"Select Thana");
        Meherpur.add("Meherpur Sadar"); Meherpur.add("Gangni"); Meherpur.add("Mujib Nagar");

        final List<String>Narail =new ArrayList<>();
        Narail.add(0,"Select Thana");
        Narail.add("Narail Sadar"); Narail.add("Lohagara"); Narail.add("Kalia");

        final List<String>Satkhira  =new ArrayList<>();
        Satkhira.add(0,"Select Thana");
        Satkhira.add("Satkhira Sadar");  Satkhira.add("Assasuni"); Satkhira.add("Debhata"); Satkhira.add("Tala");
        Satkhira.add("Kalaroa"); Satkhira.add("Kaliganj"); Satkhira.add("Shyamnagar");



        /*=====Rajshahi======*/

        final List<String>Rajshahi  =new ArrayList<>();
        Rajshahi.add(0,"Select Thana");
        Rajshahi.add("Bagha"); Rajshahi.add("Bagmara"); Rajshahi.add("Charghat"); Rajshahi.add("Durgapur"); Rajshahi.add("Godagari");
        Rajshahi.add("Mohanpur"); Rajshahi.add("Paba"); Rajshahi.add("Puthia "); Rajshahi.add("Tanore"); Rajshahi.add("Boalia");
        Rajshahi.add("Motihar"); Rajshahi.add("Shahmokhdum"); Rajshahi.add("Rajpara");

        final List<String>Bogra  =new ArrayList<>();
        Bogra.add(0,"Select Thana");
        Bogra.add("Adamdighi"); Bogra.add("Bogra Sadar"); Bogra.add("Sherpur"); Bogra.add("Dhunat"); Bogra.add("Dhupchanchia");
        Bogra.add("Gabtali"); Bogra.add("Kahaloo"); Bogra.add("Nandigram"); Bogra.add("Sahajanpur"); Bogra.add("Sariakandi ");
        Bogra.add("Shibganj"); Bogra.add("Sonatala");

        final List<String>Joypurhat  =new ArrayList<>();
        Joypurhat.add(0,"Select Thana");
        Joypurhat.add("Joypurhat Sadar"); Joypurhat.add("Akkelpur"); Joypurhat.add("Kalai"); Joypurhat.add("Khetlal");
        Joypurhat.add("Panchbibi");

        final List<String>Naogaon  =new ArrayList<>();
        Naogaon.add(0,"Select Thana");
        Naogaon.add("Naogaon Sadar");  Naogaon.add("Mohadevpur");  Naogaon.add("Manda");  Naogaon.add("Niamatpur");
        Naogaon.add("Atrai");  Naogaon.add("Raninagar");  Naogaon.add("Patnitala");  Naogaon.add("Dhamoirhat");
        Naogaon.add("Sapahar");  Naogaon.add("Porsha");  Naogaon.add("Badalgachhi");

        final List<String>Natore  =new ArrayList<>();
        Natore.add(0,"Select Thana");
        Natore.add("Natore Sadar"); Natore.add("Baraigram"); Natore.add("Bagatipara"); Natore.add("Lalpur");

        final List<String>Nawabganj =new ArrayList<>();
        Nawabganj.add(0,"Select Thana");
        Nawabganj.add("Bholahat");  Nawabganj.add("Gomastapur");  Nawabganj.add("Nachole");  Nawabganj.add("Nawabganj Sadar");
        Nawabganj.add("Shibganj");

        final List<String>Pabna =new ArrayList<>();
        Pabna.add(0,"Select Thana");
        Pabna.add("Atgharia"); Pabna.add("Bera"); Pabna.add("Bhangura"); Pabna.add("Chatmohar"); Pabna.add("Faridpur");
        Pabna.add("Ishwardi"); Pabna.add("Pabna Sadar"); Pabna.add("Santhia"); Pabna.add("Sujanagar");

        final List<String>Sirajganj =new ArrayList<>();
        Sirajganj.add(0,"Select Thana");
        Sirajganj.add("Sirajganj Sadar"); Sirajganj.add("Belkuchi"); Sirajganj.add("Chauhali"); Sirajganj.add("Kamarkhanda"); Sirajganj.add("Kazipur");
        Sirajganj.add("Raiganj"); Sirajganj.add("Shahjadpur"); Sirajganj.add("Tarash"); Sirajganj.add("Ullahpara");



        /*=====Rangpur======*/

        final List<String>Rangpur =new ArrayList<>();
        Rangpur.add(0,"Select Thana");
        Rangpur.add("Badarganj ");   Rangpur.add("Mithapukur");  Rangpur.add("Gangachara");  Rangpur.add("Kaunia");
        Rangpur.add("Rangpur Sadar");   Rangpur.add("Pirgachha");   Rangpur.add("Pirganj");  Rangpur.add("Taraganj");

        final List<String>Dinajpur =new ArrayList<>();
        Dinajpur.add(0,"Select Thana");
        Dinajpur.add("Birampur");  Dinajpur.add("Birganj"); Dinajpur.add("Biral"); Dinajpur.add("Bochaganj"); Dinajpur.add("Chirirbandar");
        Dinajpur.add("Phulbari"); Dinajpur.add("Ghoraghat"); Dinajpur.add("Hakimpur"); Dinajpur.add("Kaharole"); Dinajpur.add("Khansama");
        Dinajpur.add("Dinajpur Sadar"); Dinajpur.add("Nawabganj"); Dinajpur.add("Parbatipur");

        final List<String>Gaibandha =new ArrayList<>();
        Gaibandha.add(0,"Select Thana");
        Gaibandha.add("Fulchhari");  Gaibandha.add("Gaibandha Sadar");  Gaibandha.add("Gobindaganj");  Gaibandha.add("Palashbari");
        Gaibandha.add("Sadullapur");  Gaibandha.add("Saghata");  Gaibandha.add("Sundarganj");

        final List<String>Kurigram =new ArrayList<>();
        Kurigram.add(0,"Select Thana");
        Kurigram.add("Kurigram Sadar");  Kurigram.add("Nageshwari"); Kurigram.add("Bhurungamari"); Kurigram.add("Phulbari"); Kurigram.add("Rajarhat");
        Kurigram.add("Ulipur"); Kurigram.add("Chilmari"); Kurigram.add("Rowmari"); Kurigram.add("Char Rajibpur");

        final List<String>Lalmanirhat =new ArrayList<>();
        Lalmanirhat.add(0,"Select Thana");
        Lalmanirhat.add("Lalmanirhat Sadar");  Lalmanirhat.add("Aditmari"); Lalmanirhat.add("Kaliganj"); Lalmanirhat.add("Hatibandha");
        Lalmanirhat.add("Patgram");

        final List<String>Nilphamari =new ArrayList<>();
        Nilphamari.add(0,"Select Thana");
        Nilphamari.add("Nilphamari Sadar");  Nilphamari.add("Saidpur"); Nilphamari.add("Jaldhaka");  Nilphamari.add("Kishoreganj");
        Nilphamari.add("Domar");  Nilphamari.add("Dimla");

        final List<String>Panchagarh =new ArrayList<>();
        Panchagarh.add(0,"Select Thana");
        Panchagarh.add("Panchagarh Sadar");  Panchagarh.add("Debiganj");  Panchagarh.add("Boda");  Panchagarh.add("Atwari");
        Panchagarh.add("Tetulia");

        final List<String>Thakurgaon=new ArrayList<>();
        Thakurgaon.add(0,"Select Thana");
        Thakurgaon.add("Thakurgaon Sadar"); Thakurgaon.add("Pirganj"); Thakurgaon.add("Baliadangi"); Thakurgaon.add("Haripur");
        Thakurgaon.add("Ranisankail");



        /*=====Sylhet======*/

        final List<String>Sylhet=new ArrayList<>();
        Sylhet.add(0,"Select Thana");
        Sylhet.add("Sylhet Sadar"); Sylhet.add("Beanibazar"); Sylhet.add("Bishwanath"); Sylhet.add("Dakshin Surma"); Sylhet.add("Balaganj");
        Sylhet.add("Companiganj"); Sylhet.add("Fenchuganj"); Sylhet.add("Golapganj"); Sylhet.add("Gowainghat"); Sylhet.add("Jaintiapur");
        Sylhet.add("Kanaighat"); Sylhet.add("Zakiganj"); Sylhet.add("Nobigonj"); Sylhet.add("Airport "); Sylhet.add("Hazrat Shah Paran");
        Sylhet.add("Jalalabad"); Sylhet.add("Kowtali"); Sylhet.add("Moglabazar"); Sylhet.add("Osmani Nagar"); Sylhet.add("South Surma");

        final List<String>Habiganj=new ArrayList<>();
        Habiganj.add(0,"Select Thana");
        Habiganj.add("Ajmiriganj");  Habiganj.add("Baniachang"); Habiganj.add("Bahubal"); Habiganj.add("Chunarughat");
        Habiganj.add("Habiganj Sadar"); Habiganj.add("Lakhai"); Habiganj.add("Madhabpur"); Habiganj.add("Nabiganj");
        Habiganj.add("Shaistagonj");

        final List<String>Moulvibazar=new ArrayList<>();
        Moulvibazar.add(0,"Select Thana");
        Moulvibazar.add("Moulvibazar Sadar"); Moulvibazar.add("Barlekha"); Moulvibazar.add("Juri"); Moulvibazar.add("Kamalganj");
        Moulvibazar.add("Kulaura"); Moulvibazar.add("Rajnagar"); Moulvibazar.add("Sreemangal");

        final List<String>Sunamganj=new ArrayList<>();
        Sunamganj.add(0,"Select Thana");
        Sunamganj.add("Bishwamvarpur");  Sunamganj.add("Chhatak");  Sunamganj.add("Derai");  Sunamganj.add("Dharampasha");
        Sunamganj.add("Dowarabazar");  Sunamganj.add("Jagannathpur"); Sunamganj.add("Jamalganj");  Sunamganj.add("Sulla");
        Sunamganj.add("Sunamganj Sadar");  Sunamganj.add("Shanthiganj"); Sunamganj.add("Tahirpur");



        /*=====Mymensingh======*/

        final List<String>Mymensingh=new ArrayList<>();
        Mymensingh.add(0,"Select Thana");
        Mymensingh.add("Bhaluka"); Mymensingh.add("Trishal"); Mymensingh.add("Haluaghat"); Mymensingh.add("Muktagachha"); Mymensingh.add("Dhobaura");
        Mymensingh.add("Fulbaria"); Mymensingh.add("Gaffargaon"); Mymensingh.add("Gauripur"); Mymensingh.add("Ishwarganj"); Mymensingh.add("Mymensingh Sadar");
        Mymensingh.add("Nandail"); Mymensingh.add("Phulpur");

        final List<String>Jamalpur=new ArrayList<>();
        Jamalpur.add(0,"Select Thana");
        Jamalpur.add("Dewanganj"); Jamalpur.add("Baksiganj"); Jamalpur.add("Islampur"); Jamalpur.add("Jamalpur Sadar");
        Jamalpur.add("Madarganj"); Jamalpur.add("Melandaha"); Jamalpur.add("Sarishabari"); Jamalpur.add("Narundi");

        final List<String>Netrakona=new ArrayList<>();
        Netrakona.add(0,"Select Thana");
        Netrakona.add("Kendua"); Netrakona.add("Atpara"); Netrakona.add("Barhatta"); Netrakona.add("Durgapur"); Netrakona.add("Kalmakanda");
        Netrakona.add("Madan"); Netrakona.add("Mohanganj"); Netrakona.add("Netrakona Sadar"); Netrakona.add("Purbadhala"); Netrakona.add("Khaliajuri");

        final List<String>Sherpur=new ArrayList<>();
        Sherpur.add(0,"Select Thana");
        Sherpur.add("Jhenaigati"); Sherpur.add("Nakla"); Sherpur.add("Nalitabari"); Sherpur.add("Sherpur Sadar"); Sherpur.add("Sreebardi");
























        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,District);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_district.setAdapter(dataAdapter);


        sp_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (parent.getItemAtPosition(position).equals("Select Thana")){

                }else {
                    t6.setText(parent.getSelectedItem().toString());
                }

                if (position == 1) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Dhaka);
                    sp_thana.setAdapter(thanaAdapter);
                }

                else {

                }

                if (position == 2) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Faridpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 3) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Madaripur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 4) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Gazipur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 5) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Gopalganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 6) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Kishoreganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 7) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Manikganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 8) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Munshiganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 9) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Naryanganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 10) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Narsingdi);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 11) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Rajbari);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 12) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Shariatpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 13) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Tangail);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 14) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Barisal);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 15) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,Barguna);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 16) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Bhola);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 17) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Jhalokati);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 18) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Patuakhali);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 19) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Pirojpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 20) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Chattogram);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 21) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Bandarban);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 22) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Brahmanbaria);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 23) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Chandpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 24) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Comilla);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 25) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, CoxsBazar);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 26) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Feni);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 27) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Khagrachhari);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 28) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Lakshmipur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 29) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Noakhali);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 30) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Rangamati);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 31) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Khulna);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 32) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Bagerhat);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 33) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Chuadanga);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 34) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Jessore);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 35) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Jhenaidah);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 36) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Kushtia);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 37) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Magura);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 38) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,Meherpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 39) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Narail);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 40) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Satkhira);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 41) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,Rajshahi);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 42) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Bogra);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 43) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Joypurhat);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 44) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Naogaon);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 45) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Natore);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 46) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Nawabganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 47) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Pabna);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 48) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Sirajganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 49) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,Rangpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 50) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Dinajpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 51) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Gaibandha);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 52) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Kurigram);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 53) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Lalmanirhat);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 54) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Nilphamari);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 55) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Panchagarh);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 56) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Thakurgaon);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 57) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Sylhet);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }
                if (position == 58) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Habiganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 59) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Moulvibazar);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 60) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Sunamganj);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 61) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Mymensingh);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 62) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Jamalpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 63) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Netrakona);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }

                if (position == 64) {
                    ArrayAdapter<String> thanaAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Sherpur);
                    sp_thana.setAdapter(thanaAdapter);
                } else {

                }


            }




            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_thana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Select Thana")){

                }else {
                    t7.setText(parent.getSelectedItem().toString());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        registered=findViewById(R.id.tv_already_have_an_account);
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodBankAdminRegisterActivity.this,BloodBankAdminSignInActivity.class);
                startActivity(intent);
            }
        });

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Blood Bank Pending");

                String username =t1.getText().toString().trim();
                String password =t2.getText().toString().trim();
                String name =t3.getText().toString().trim();
                String phone =t4.getText().toString().trim();
                String address =t5.getText().toString().trim();
                String district = t6.getText().toString().trim();
                String thana = t7.getText().toString().trim();




                bloodbankModel model = new bloodbankModel(username,password,name,phone,address,district,thana);
                reference.child(phone).setValue(model);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");


                Toast.makeText(getApplicationContext(),"Data Inserted Successfully & Wait for Admin Approval",Toast.LENGTH_LONG).show();

            }
        });


    }

    private Boolean validateUserName(){
        String val = t1.getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()){
            t1.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=15){
            t1.setError("Username too long");
            return false;
        }else if (!val.matches(noWhiteSpace)){
            t1.setError("White Spaces are not allowed");
            return false;
        }
        else {
            t1.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = t2.getText().toString();
        String passwordVal= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        if (val.isEmpty()){
            t2.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(passwordVal)){
            t2.setError("Password is too weak");
            return false;
        }
        else {
            t2.setError(null);
            return true;
        }
    }
    private Boolean validateName(){
        String val = t3.getText().toString();

        if (val.isEmpty()){
            t3.setError("Field cannot be empty");
            return false;
        }
        else {
            t3.setError(null);

            return true;
        }
    }
    private Boolean validatePhone(){
        String val = t4.getText().toString();

        if (val.isEmpty()){
            t4.setError("Field cannot be empty");
            return false;
        }
        else {
            t4.setError(null);
            return true;
        }
    }
    private Boolean validateAddress(){
        String val = t5.getText().toString();

        if (val.isEmpty()){
            t5.setError("Field cannot be empty");
            return false;
        }
        else {
            t5.setError(null);
            return true;
        }
    }
    private Boolean validateDistrict(){
        String val = t6.getText().toString();

        if (val.isEmpty()){
            t6.setError("Field cannot be empty");
            return false;
        }
        else {
            t6.setError(null);
            return true;
        }
    }
    private Boolean validateThana(){
        String val = t7.getText().toString();

        if (val.isEmpty()){
            t7.setError("Field cannot be empty");
            return false;
        }
        else {
            t7.setError(null);
            return true;
        }
    }

    public  void registerUser(View view){

        if (!validateUserName() | !validatePassword() | !validateName()  | !validatePhone() |  !validateAddress() | !validateDistrict() | !validateThana()){
            return;
        }


        String username =t1.getText().toString();
        String password =t2.getText().toString();
        String name =t3.getText().toString();
        String phone =t4.getText().toString();
        String address =t5.getText().toString();
        String district =t6.getText().toString();
        String thana =t7.getText().toString();

        bloodbankModel model = new bloodbankModel(username,password,name,phone,address,district,thana);
        reference.child(phone).setValue(model);
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(t1.getText()) && validateUserName()){
            if(!TextUtils.isEmpty(t2.getText()) && validatePassword()){
                if (!TextUtils.isEmpty(t3.getText()) && validateName()){
                    if (!TextUtils.isEmpty(t4.getText()) && validatePhone()){
                        if (!TextUtils.isEmpty(t5.getText()) && validateAddress()){
                            if (!TextUtils.isEmpty(t6.getText()) && validateDistrict()){
                                if (!TextUtils.isEmpty(t7.getText()) && validateThana()){
                                    sign_up_btn.setEnabled(true);
                                    sign_up_btn.setTextColor(Color.rgb(255,255,255));
                                }else {
                                    sign_up_btn.setEnabled(false);
                                    sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                                }

                            }else {
                                sign_up_btn.setEnabled(false);
                                sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                            }


                        }else {
                            sign_up_btn.setEnabled(false);
                            sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                        }

                    }else {
                        sign_up_btn.setEnabled(false);
                        sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                    }

                }else {
                    sign_up_btn.setEnabled(false);
                    sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                }

            }else {
                sign_up_btn.setEnabled(false);
                sign_up_btn.setTextColor(Color.argb(50,255,255,255));
            }

        }else {
            sign_up_btn.setEnabled(false);
            sign_up_btn.setTextColor(Color.argb(50,255,255,255));
        }




    }
}