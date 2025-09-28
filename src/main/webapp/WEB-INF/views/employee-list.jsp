<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Employees</title>
    <!-- Tailwind CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

    <div class="container mx-auto px-4 py-8">

        <h2 class="text-3xl font-bold text-blue-900 mb-6 text-center">Employee List</h2>

        <a href="${pageContext.request.contextPath}/employees/new" 
           class="bg-blue-600 text-white px-4 py-2 rounded shadow hover:bg-blue-700 transition d-flex flex-end">
           Add Employee
        </a>

        <div class="overflow-x-auto mt-6">
            <table class="min-w-full bg-white shadow-md rounded-lg overflow-hidden">
                <thead class="bg-blue-900 text-white">
                    <tr>
                        <th class="py-3 px-6 text-left">ID</th>
                        <th class="py-3 px-6 text-left">Name</th>
                        <th class="py-3 px-6 text-left">Email</th>
                        <th class="py-3 px-6 text-left">DOB</th>
                        <th class="py-3 px-6 text-left">Department</th>
                        <th class="py-3 px-6 text-left">Actions</th>
                    </tr>
                </thead>
                <tbody class="divide-y divide-gray-200">
                    <c:forEach var="emp" items="${employees}">
                        <tr class="hover:bg-gray-100 transition">
                            <td class="py-3 px-6">${emp.id}</td>
                            <td class="py-3 px-6">${emp.name}</td>
                            <td class="py-3 px-6">${emp.email}</td>
                            <td class="py-3 px-6">${emp.dob}</td>
                            <td class="py-3 px-6">${emp.department}</td>
                            <td class="py-3 px-6">
                                <a href="${pageContext.request.contextPath}/employees/edit/${emp.id}" 
                                   class="text-blue-600 hover:text-blue-800 font-semibold mr-2">Edit</a>
                                <a href="${pageContext.request.contextPath}/employees/delete/${emp.id}" 
                                   onclick="return confirm('Are you sure?')" 
                                   class="text-red-600 hover:text-red-800 font-semibold">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</body>
</html>
