

new Vue({
	el: '#app',
	mounted: function() {
		this.refresh();
	},
	data: function() {
		return {
			employees: null,
			employee: {},
			formVisible: false,
		}
	},
	methods: {
		refresh: function() {
			axios.get('employee').then(response => {
				this.employees = response.data;
			});
		},
		showEmp: function(id) {
			this.formVisible = true;
			axios.get('employee/' + id).then(response => {
				this.employee = response.data;
			});
		},
		deleteEmp: function(id) {
			if (window.confirm("¿Esta seguro de borrar el empleado?")) {
				axios.delete('employee/' + id).then(response => {
					this.clearFields();
					this.refresh();
				}).catch(error => {
					alert(error);
				});
			}
		},
		newEmployee: function() {
			this.formVisible=true;
			this.employee = {};
		},
		saveEmployee: function() {
			if (this.employee.id) {
				const url = `employee/${this.employee.id}`;
				axios.put(url, this.employee).then(response => {
					this.refresh();
					this.clearFields();
					alert(response.data);
					this.formVisible = false;
				}).catch(error => {
					alert(error);
				});
			} else {
				axios.post('employee', this.employee).then(response => {
					this.refresh();
					this.clearFields();
					alert(response.data);
					this.formVisible = false;
				});
			}
		},
		clearFields: function() {
			this.employee = {};
		},
		cancelForm: function() {
			this.formVisible = false;
		},
	}
});