<div class="container">
<table class="table">
   <thead>
       <tr>
           <th>Id Client</th>
           <th>Name</th>
           <th>Phone</th>
           <th>Details</th>
           <th>Orders</th>
           <th></th>
       </tr>
   </thead>
   <tbody>
       <tr>
           <td ng-bind="client.id_cl" ng-model="client.id_cl"></td>
           <td js-edit="client.name" class="js-editable">
               <span class="js-editable-wrap-text" ng-bind="client.name"></span>
               <form class="js-editable-form" name="myForm">
                   <input type="text" class="js-editable-input js-editable-field" ng-model="client.name" ng-required/>
                   <button class="js-editable-icon" type="submit"></button>
               </form>
           </td>
           <td js-edit="client.telephone" class="js-editable">
               <span class="js-editable-wrap-text"  ng-bind="client.telephone"></span>
               <form class="js-editable-form" name="myForm">
                   <input type="text" class="js-editable-input js-editable-field" ng-model="client.telephone" ng-required/>
                   <button class="js-editable-icon" type="submit"></button>
               </form>
           </td>
           <td  js-edit="client.details" class="js-editable">
               <span class="js-editable-wrap-text" ng-bind="client.details"></span>
               <form class="js-editable-form" name="myForm">
                   <input type="text" class="js-editable-input js-editable-field" ng-model="client.details" ng-required/>
                   <button class="js-editable-icon" type="submit"></button>
               </form>
           </td>
           <td>
               <div class="dropdown">
                   <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" ng-bind="client.orders.length">
                       <span class="caret"></span>
                   </button>
                   <ul class="dropdown-menu"  >
                       <li ng-repeat="order in client.orders">
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
</div>