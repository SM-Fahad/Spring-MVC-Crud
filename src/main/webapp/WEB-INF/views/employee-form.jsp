<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee Form</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

    <div class="container mx-auto px-4 py-8">
        <h2 class="text-3xl font-bold text-blue-900 mb-6 text-center">Employee Form</h2>

        <form action="${pageContext.request.contextPath}/employees" method="post" 
              class="bg-white p-6 rounded-lg shadow-md max-w-lg mx-auto space-y-4">

            <input type="hidden" name="id" value="${employee.id}" />

            <div>
                <label class="block text-gray-700 font-semibold mb-1" for="name">Name</label>
                <input type="text" id="name" name="name" value="${employee.name}" 
                       class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div>
                <label class="block text-gray-700 font-semibold mb-1" for="email">Email</label>
                <input type="email" id="email" name="email" value="${employee.email}" 
                       class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div>
				<label class="block text-gray-700 font-semibold mb-1" for="dob">DOB</label>
                <input type="date" id="dob" name="dobStr" value="${employee.dob != null ? employee.dob.toString().substring(0,10) : ''}"
                       class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div>
                <label class="block text-gray-700 font-semibold mb-1" for="department">Department</label>
                <input type="text" id="department" name="department" value="${employee.department}" 
                       class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div class="text-center">
                <button type="submit" 
                        class="bg-blue-600 text-white px-6 py-2 rounded shadow hover:bg-blue-700 transition">
                    Save
                </button>
            </div>

        </form>
    </div>

</body>
</html>
