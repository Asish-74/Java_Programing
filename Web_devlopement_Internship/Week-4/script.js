document.addEventListener('DOMContentLoaded', function () {
    // Check for existing tasks in local storage
    let tasks = JSON.parse(localStorage.getItem('tasks')) || [];

    // Render existing tasks
    renderTasks();

    // Function to render tasks
    function renderTasks() {
        const taskList = document.getElementById('task-list');
        taskList.innerHTML = '';

        tasks.forEach(function (task, index) {
            const taskElement = document.createElement('div');
            taskElement.classList.add('task');
            if (task.completed) {
                taskElement.classList.add('completed');
            }

            taskElement.innerHTML = `
                <span>${task.title}</span>
                <div class="task-actions">
                    <button onclick="toggleCompletion(${index})">${task.completed ? 'Undo' : 'Complete'}</button>
                    <button onclick="editTask(${index})">Edit</button>
                    <button onclick="deleteTask(${index})">Delete</button>
                </div>
            `;

            taskList.appendChild(taskElement);
        });
    }

    // Function to add a new task
    window.addTask = function () {
        const newTaskInput = document.getElementById('new-task');
        const newTaskTitle = newTaskInput.value.trim();

        if (newTaskTitle !== '') {
            const newTask = {
                title: newTaskTitle,
                completed: false,
            };

            tasks.push(newTask);
            localStorage.setItem('tasks', JSON.stringify(tasks));

            newTaskInput.value = ''; // Clear input
            renderTasks();
        }
    };

    // Function to toggle task completion status
    window.toggleCompletion = function (index) {
        tasks[index].completed = !tasks[index].completed;
        localStorage.setItem('tasks', JSON.stringify(tasks));
        renderTasks();
    };

    // Function to edit a task
    window.editTask = function (index) {
        const newTitle = prompt('Edit task:', tasks[index].title);

        if (newTitle !== null) {
            tasks[index].title = newTitle.trim();
            localStorage.setItem('tasks', JSON.stringify(tasks));
            renderTasks();
        }
    };

    // Function to delete a task
    window.deleteTask = function (index) {
        const confirmDelete = confirm('Are you sure you want to delete this task?');

        if (confirmDelete) {
            tasks.splice(index, 1);
            localStorage.setItem('tasks', JSON.stringify(tasks));
            renderTasks();
        }
    };
});
