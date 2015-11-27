<table class="table">
    <thead>
    <tr>
        <th>Id Employee</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Is Active</th>
        <th>Orders</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td ng-bind="employee.id_emp" ng-model="employee.id_emp"></td>
        <td js-edit="employee.name" class="js-editable">
            <span class="js-editable-wrap-text" ng-bind="employee.name"></span>
            <form class="js-editable-form" name="myForm">
                <input type="text" class="js-editable-input js-editable-field" ng-model="employee.name" ng-required/>
                <button class="js-editable-icon" type="submit"></button>
            </form>
        </td>
        <td js-edit="employee.surname" class="js-editable">
            <span class="js-editable-wrap-text"  ng-bind="employee.surname"></span>
            <form class="js-editable-form" name="myForm">
                <input type="text" class="js-editable-input js-editable-field" ng-model="employee.surname" ng-required/>
                <button class="js-editable-icon" type="submit"></button>
            </form>
        </td>
        <td js-edit="employee.isActive" class="js-editable">
            <span class="js-editable-wrap-text"  ng-bind="employee.isActive"></span>
            <form class="js-editable-form" name="myForm">
                <input type="text" class="js-editable-input js-editable-field" ng-model="employee.isActive" ng-required/>
                <button class="js-editable-icon" type="submit"></button>
            </form>
        </td>
        <td>
            <div class="dropdown">
                <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" ng-bind="employee.orders.length">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu"  >
                    <li ng-repeat="order in employee.orders">
                        <a href="#/items/Orders/{{order.id_order}}" ng-bind="order.orderscol"></a>
                    </li>
                </ul>
            </div>
        </td>
        <td>
            <button class="btn btn-primary" ng-click="saveItem()">Submit</button>
        </td>
    </tr>
    </tbody>
</table>
