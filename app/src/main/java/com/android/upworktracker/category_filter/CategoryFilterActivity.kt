package com.android.upworktracker.category_filter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.category.*

class CategoryFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category)

        val accountingAndConsultingData =
            arrayListOf(
                "All -Accounting & Consulting",
                "Accounting",
                "Financial Planning",
                "Human Resources",
                "Management Consulting",
                "Other - Accounting & Consulting"
            )
        val accountingAndConsultingAdapter = CategoryAdapter(accountingAndConsultingData)
        accountingAndConsultingRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = accountingAndConsultingAdapter
        }

        val adminSupportData =
            arrayListOf(
                "All - Admin Support",
                "Data Entry",
                "Other - Admin Support",
                "Personal/Virtual Assistant",
                "Project Management",
                "Transcription",
                "Web Research"
            )
        val adminSupportAdapter = CategoryAdapter(adminSupportData)
        adminSupportRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = adminSupportAdapter
        }

        val customerServiceData =
            arrayListOf(
                "All - Customer Service",
                "Customer Service",
                "Other - Customer Service",
                "Technical Support"
            )
        val customerServiceAdapter = CategoryAdapter(customerServiceData)
        customerServiceRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = customerServiceAdapter
        }

        val dataScienceAndAnalyticsData =
            arrayListOf(
                "All - Data Science & Analytics, A/B Testing",
                "A/B Testing",
                "Data Extraction/ETL",
                "Data Mining & Management",
                "Data Visualization",
                "Machine Learning",
                "Other - Data Science & Analytics",
                "Quantitative Analysis"
            )
        val dataScienceAndAnalyticsAdapter = CategoryAdapter(dataScienceAndAnalyticsData)
        dataScienceAndAnalyticsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = dataScienceAndAnalyticsAdapter
        }

        val designAndCreativeData =
            arrayListOf(
                "All - Design & Creative",
                "Animation",
                "Art & Illustration",
                "Audio Production",
                "Brand Identity & Strategy",
                "Graphics & Design",
                "Motion Graphics",
                "Photography",
                "Physical Design",
                "Presentations",
                "Video Production",
                "Voice Talent"
            )
        val designAndCreativeAdapter = CategoryAdapter(designAndCreativeData)
        designAndCreativeRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = designAndCreativeAdapter
        }

        val engineeringAndArchitectureData =
            arrayListOf(
                "All - Engineering & Architecture",
                "3D Modeling & CAD",
                "Architecture",
                "Chemical Engineering",
                "Civil & Structural Engineering",
                "Contract Manufacturing",
                "Electrical Engineering",
                "Interior Design",
                "Mechanical Engineering",
                "Other - Engineering & Architecture",
                "Product Design"
            )
        val engineeringAndArchitectureAdapter = CategoryAdapter(engineeringAndArchitectureData)
        engineeringAndArchitectureRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = engineeringAndArchitectureAdapter
        }

        val itAndNetworkingData = arrayListOf(
            "All - IT & Networking",
            "Database Administration",
            "ERP/CRM Software",
            "Information Security",
            "Networking & System Administration",
            "Other - IT & Networking"
        )
        val itAndNetworkingAdapter = CategoryAdapter(itAndNetworkingData)
        itAndNetworkingRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = itAndNetworkingAdapter
        }

        val legalData = arrayListOf(
            "All - Legal",
            "Contract Law",
            "Corporate Law",
            "Criminal Law",
            "Family Law",
            "Intellectual Property Law",
            "Other - Legal",
            "Paralegal Services"
        )
        val legalAdapter = CategoryAdapter(legalData)
        legalRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = legalAdapter
        }

        val salesAndMarketingData = arrayListOf(
            "All - Sales & Marketing",
            "Display Advertising",
            "Email & Marketing Automation",
            "Lead Generation",
            "Market & Customer Research",
            "Marketing Strategy",
            "Other - Sales & Marketing",
            "Public Relation",
            "SEM - Search Engine Marketing",
            "SEO - Search Engine Optimization",
            "SMM - Social Media Marketing",
            "Telemarketing & Telesales"
        )
        val salesAndMarketingAdapter = CategoryAdapter(salesAndMarketingData)
        salesAndMarketingRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = salesAndMarketingAdapter
        }

        val translationData = arrayListOf(
            "All - Translation",
            "General Translation",
            "Legal Translation",
            "Medical Translation",
            "Technical Translation"
        )
        val translationAdapter = CategoryAdapter(translationData)
        translationRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = translationAdapter
        }

        val webMobileAndSoftwareDevData = arrayListOf(
            "All - Web, Mobile & Software Dev",
            "Desktop Software Development",
            "Ecommerce Development",
            "Game Development",
            "Mobile Development",
            "Other - Software Development",
            "Product Management",
            "QA & Testing",
            "Scripts & Utilities",
            "Web & Mobile Design",
            "Web Development"
        )
        val webMobileAndSoftwareAdapter = CategoryAdapter(webMobileAndSoftwareDevData)
        webMobileAndSoftwareDevRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = webMobileAndSoftwareAdapter
        }

        val writingData = arrayListOf(
            "All - Writing",
            "Academic Writing & Research",
            "Article & Blog Writing",
            "Copywriting",
            "Creative Writing",
            "Editing & Proofreading",
            "Grant Writing",
            "Other - Writing",
            "Resumes & Cover Letters"
        )
        val writingAdapter = CategoryAdapter(writingData)
        writingRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryFilterActivity)
            adapter = writingAdapter
        }

    }
}
