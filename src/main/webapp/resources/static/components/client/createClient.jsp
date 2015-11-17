<!-- FORM -->
<h1>Create client</h1>
<!-- pass in the variable if our form is valid or invalid -->
<form name="clientForm" ng-submit="saveClient()" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->

  <!-- NAME -->
  <div ng-class="{ 'has-error' : clientForm.name.$invalid && !clientForm.name.$pristine }">
    <label>Client name</label>
    <input type="text" name="name" class="form-control" ng-model="client.name" required ng-minlength="3" ng-maxlength="16">
    <p ng-show="clientForm.name.$error.minlength" class="help-block">Client name is too short.</p>
    <p ng-show="clientForm.name.$error.maxlength" class="help-block">Client name is too long.</p>
  </div>

  <!-- Phone-->
  <div ng-class="{ 'has-error' : clientForm.phone.$invalid && !clientForm.phone.$pristine }">
    <label>Phone</label>
    <input type="text" name="phone" class="form-control" ng-model="client.telephone" ng-pattern="/\d{3}-\d{3}-\d{4}/" required placeholder="555-555-5555"/>
    <p ng-show="clientForm.phone.$error.pattern" class="help-block">Enter valid number!</p>
  </div>

  <!-- Details -->
  <div class="form-group">
    <label>Details</label>
    <input type="text" name="details" class="form-control" ng-model="client.details">
  </div>

  <!-- SUBMIT BUTTON -->
  <button type="submit" class="btn btn-primary">Submit</button>

</form>