package com.android.upworktracker.bottom_sheet.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.category_list.*

class CategoryFragment : Fragment() {

    lateinit var adapter: CategoryAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list, container, false)
    }

    companion object {
            fun newInstance() =
                    CategoryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = arrayListOf(
                "Accounting & Consulting" to listOf("Accounting",
                        "Financial Planning",
                        "Human Resources",
                        "Management Consulting",
                        "Other - Accounting & Consulting"),

                "Admin Support" to listOf(
                        "Data Entry",
                        "Other - Admin Support",
                        "Personal/Virtual Assistant",
                        "Project Management",
                        "Transcription",
                        "Web Research"),

                "Customer Service" to listOf("Customer Service",
                        "Other - Customer Service",
                        "Technical Support"),

                "Data Science & Analytics, A/B Testing" to listOf(
                        "A/B Testing",
                        "Data Extraction/ETL",
                        "Data Mining & Management",
                        "Data Visualization",
                        "Machine Learning",
                        "Other - Data Science & Analytics",
                        "Quantitative Analysis"),

                "Design & Creative" to listOf("Animation",
                        "Art & Illustration",
                        "Audio Production",
                        "Brand Identity & Strategy",
                        "Graphics & Design",
                        "Motion Graphics",
                        "Photography",
                        "Physical Design",
                        "Presentations",
                        "Video Production",
                        "Voice Talent"),

                "Engineering & Architecture" to listOf(
                        "3D Modeling & CAD",
                        "Architecture",
                        "Chemical Engineering",
                        "Civil & Structural Engineering",
                        "Contract Manufacturing",
                        "Electrical Engineering",
                        "Interior Design",
                        "Mechanical Engineering",
                        "Other - Engineering & Architecture",
                        "Product Design"),

                "IT & Networking" to listOf(
                        "Database Administration",
                        "ERP/CRM Software",
                        "Information Security",
                        "Networking & System Administration",
                        "Other - IT & Networking"),

                "Legal" to listOf(
                        "Contract Law",
                        "Corporate Law",
                        "Criminal Law",
                        "Family Law",
                        "Intellectual Property Law",
                        "Other - Legal",
                        "Paralegal Services"),

                "Sales & Marketing" to listOf(
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
                        "Telemarketing & Telesales"),

                "Translation" to listOf(
                        "General Translation",
                        "Legal Translation",
                        "Medical Translation",
                        "Technical Translation"),

                "Web, Mobile & Software Dev" to listOf(
                        "Desktop Software Development",
                        "Ecommerce Development",
                        "Game Development",
                        "Mobile Development",
                        "Other - Software Development",
                        "Product Management",
                        "QA & Testing",
                        "Scripts & Utilities",
                        "Web & Mobile Design",
                        "Web Development"),

                "Writing" to listOf(
                        "Academic Writing & Research",
                        "Article & Blog Writing",
                        "Copywriting",
                        "Creative Writing",
                        "Editing & Proofreading",
                        "Grant Writing",
                        "Other - Writing",
                        "Resumes & Cover Letters"
                )
        )

            adapter =
                    CategoryAdapter(
                            database
                    )
        categoryListRecyclerView.adapter = adapter
        categoryListRecyclerView.layoutManager = LinearLayoutManager(view.context)

    }

    fun clearCheckboxes() {
        adapter.notifyDataSetChanged()
    }

}