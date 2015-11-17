<div class="container">
    <h2 ng-bind="tableName"></h2>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id Order</th>
                <th>Order</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr data-ng-repeat="order in listOrders">
                <td ng-bind="order.id_order"></td>
                <td ng-bind="order.orderscol"></td>
                <td>
                    <a href="#/items/Orders/edit/{{order.id_order}}" class="btn btn-default" data-toggle="tooltip" title="Edit order"><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="#/items/Orders/del/{{order.id_order}}" class="btn btn-default" data-toggle="tooltip" title="Delete order"><span class="glyphicon glyphicon-remove"></span></a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<a href="#/items/Orders/new" class="btn btn-primary">New Order</a>