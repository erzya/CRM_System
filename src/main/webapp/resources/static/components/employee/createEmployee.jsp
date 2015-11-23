<!-- FORM -->
<h1>Create employee</h1>
<!-- pass in the variable if our form is valid or invalid -->
<form name="employeeForm" ng-submit="saveEmployee()" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->

  <!-- NAME -->
  <div ng-class="{ 'has-error' : employeeForm.name.$invalid && !employeeForm.name.$pristine }">
    <label>Client name</label>
    <input type="text" name="name" class="form-control" ng-model="employee.name" required ng-minlength="3" ng-maxlength="16">
    <p ng-show="employeeForm.name.$error.minlength" class="help-block">Client name is too short.</p>
    <p ng-show="employeeForm.name.$error.maxlength" class="help-block">Client name is too long.</p>
  </div>
  <!-- SURNAME -->
  <div ng-class="{ 'has-error' : employeeForm.surname.$invalid && !employeeForm.surname.$pristine }">
    <label>Client surname</label>
    <input type="text" name="surname" class="form-control" ng-model="employee.surname" required ng-minlength="3" ng-maxlength="16">
    <p ng-show="employeeForm.surname.$error.minlength" class="help-block">Client surname is too short.</p>
    <p ng-show="employeeForm.surname.$error.maxlength" class="help-block">Client surname is too long.</p>
  </div>

  <!-- IsActive -->
  <div class="form-group">
    <label>IsActive:</label>
    <input type="checkbox" name="isActive" ng-click="employee.isActive=!employee.isActive"
           ng-checked="employee.isActive"
           ng-model="employee.isActive">
  </div>

  <!-- SUBMIT BUTTON -->
  <button type="submit" class="btn btn-primary">Submit</button>

</form>