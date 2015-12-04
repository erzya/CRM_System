<!-- FORM -->
<h1>Create order</h1>
<!-- pass in the variable if our form is valid or invalid -->
<form name="orderForm" ng-submit="saveOrder()" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->

  <!-- OrderColumn -->
  <div class="form-group">
    <label>Order description</label>
    <input type="text" name="description" class="form-control" ng-model="order.orderscol">
  </div>

  <!-- Client-->
  <div ng-class="{'has-error' : orderForm.client.$invalid && !clientForm.name.$pristine}">
    <label>Client</label>

  <%--<input id="inputOrderSelect" type="text" name="client" class="form-control" ng-value="fieldValue" required />--%>
      <select class="form-control" name="client" ng-model="order.client" ng-options="client.name for client in listClients" required>
          <option value="">Select Client</option>
      </select>
      <br/>
  </div>

    <!--Employee-->
    <div ng-class="{'has-error' : orderForm.employee.$invalid && !employeeForm.name.$pristine}">
        <label>Employee</label>

        <select class="form-control" name="employee" ng-model="order.employee" ng-options="employee.surname for employee in listEmployees" required>
            <option value="">Select Employee</option>
        </select>
        <br/>
    </div>

  <!-- SUBMIT BUTTON -->
  <button type="submit" class="btn btn-primary">Submit</button>

</form>