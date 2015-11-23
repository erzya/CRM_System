<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id Order</th>
            <th>Order</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td ng-bind="orderObj.id_order"></td>
            <td js-edit="orderObj.orderscol" class="js-editable">
                <span class="js-editable-wrap-text"  ng-bind="orderObj.orderscol"></span>
                <form class="js-editable-form" name="myForm">
                    <input type="text" class="js-editable-input js-editable-field" ng-model="orderObj.orderscol"  ng-required/>
                    <button class="js-editable-icon" type="submit"></button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>