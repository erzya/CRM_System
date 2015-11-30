<!-- FORM -->
<h1>Create employee</h1>
<!-- pass in the variable if our form is valid or invalid -->
<form name="employeeForm" ng-submit="saveEmployee()" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->

    <!-- NAME -->
    <div ng-class="{ 'has-error' : employeeForm.name.$invalid && !employeeForm.name.$pristine}">
        <label>Employee name</label>
        <input type="text" name="name" class="form-control" ng-model="employee.name" required ng-pattern="/[A-Za-z]*/" ng-minlength="3" ng-maxlength="30">
        <p ng-show="employeeForm.name.$error.required">You did not enter a field</p>
        <p ng-show="employeeForm.name.$error.minlength" class="help-block">Employee name should be over 2 characters</p>
        <p ng-show="employeeForm.name.$error.maxlength" class="help-block">Employee name should be less than 30 characters</p>
        <p ng-show="employeeForm.name.$error.pattern" class="help-block">Only letters allowed</p>
    </div>

    <!-- SURNAME -->
    <div ng-class="{ 'has-error' : employeeForm.surname.$invalid && !employeeForm.surname.$pristine}">
        <label>Employee surname</label>
        <input type="text" name="surname" class="form-control" ng-model="employee.surname" required ng-pattern="/[A-Za-z]*/" ng-minlength="3" ng-maxlength="30">
        <p ng-show="employeeForm.surname.$error.required">You did not enter a field</p>
        <p ng-show="employeeForm.surname.$error.minlength" class="help-block">Employee surname should be over 2 characters</p>
        <p ng-show="employeeForm.surname.$error.maxlength" class="help-block">Employee surname should be less than 30 characters</p>
        <p ng-show="employeeForm.surname.$error.pattern" class="help-block">Only letters allowed</p>
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