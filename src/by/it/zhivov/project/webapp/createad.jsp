<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateAd" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Create Ad</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="title">Title</label>
                <div class="col-md-4">
                    <input id="title" name="title" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Description</label>
                <div class="col-md-4">
                    <textarea id="description" name="description" maxlength="2000" placeholder="Enter the description" class="form-control input-md" required=""></textarea>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="brnd">Brand</label>
                <div class="col-md-4">
                    <select id="brnd" name="brnd" class="form-control">
                        <option value="Acura">Acura</option>
                        <option value="Aston Martin">Aston Martin</option>
                        <option value="Audi">Audi</option>
                        <option value="Bentley">Bentley</option>
                        <option value="BMW">BMW</option>
                        <option value="Buick">Buick</option>
                        <option value="BYD">BYD</option>
                        <option value="Cadillac">Cadillac</option>
                        <option value="Chevrolet">Chevrolet</option>
                        <option value="Chrysler">Chrysler</option>
                        <option value="Citroen">Citroën</option>
                        <option value="Dacia">Dacia</option>
                        <option value="DAF">DAF</option>
                        <option value="Daihatsu">Daihatsu</option>
                        <option value="Dodge">Dodge</option>
                        <option value="Ferrari">Ferrari</option>
                        <option value="Fiat">Fiat</option>
                        <option value="Ford">Ford</option>
                        <option value="Geely">Geely</option>
                        <option value="GMC">GMC</option>
                        <option value="Honda">Honda</option>
                        <option value="Hyundai">Hyundai</option>
                        <option value="Infiniti">Infiniti</option>
                        <option value="Jaguar">Jaguar</option>
                        <option value="Kia">Kia</option>
                        <option value="Lamborghini">Lamborghini</option>
                        <option value="Land Rover">Land Rover</option>
                        <option value="Lexus">Lexus</option>
                        <option value="Lincoln">Lincoln</option>
                        <option value="Mack">Mack</option>
                        <option value="Maserati">Maserati</option>
                        <option value="Mazda">Mazda</option>
                        <option value="McLaren">McLaren</option>
                        <option value="Mercedes-Benz">Mercedes-Benz</option>
                        <option value="MINI">MINI</option>
                        <option value="Mitsubishi">Mitsubishi</option>
                        <option value="Nissan">Nissan</option>
                        <option value="Opel">Opel</option>
                        <option value="Peugeot">Peugeot</option>
                        <option value="Porsche">Porsche</option>
                        <option value="Renault">Renault</option>
                        <option value="Rolls-Royce">Rolls-Royce</option>
                        <option value="Seat">Seat</option>
                        <option value="Skoda">Skoda</option>
                        <option value="Smart">Smart</option>
                        <option value="SSangYong">SSangYong</option>
                        <option value="Subaru">Subaru</option>
                        <option value="Suzuki">Suzuki</option>
                        <option value="Tesla">Tesla</option>
                        <option value="Toyota">Toyota</option>
                        <option value="Volkswagen">Volkswagen</option>
                        <option value="Volvo">Volvo</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Model</label>
                <div class="col-md-4">
                    <input id="model" name="model" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="color">Color</label>
                <div class="col-md-4">
                    <input id="color" name="color" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="body">Body</label>
                <div class="col-md-4">
                    <select id="body" name="body" class="form-control">
                        <option value="Sedan">Sedan</option>
                        <option value="Hatchback">Hatchback</option>
                        <option value="Universal">Universal</option>
                        <option value="Liftback">Liftback</option>
                        <option value="Coupe">Coupe</option>
                        <option value="Cabriolet">Cabriolet</option>
                        <option value="Roadster">Roadster</option>
                        <option value="Targa">Targa</option>
                        <option value="Limo">Limo</option>
                        <option value="Offroad">Offroad</option>
                        <option value="Crossover">Crossover</option>
                        <option value="Pickup">Pickup</option>
                        <option value="Furgon">Furgon</option>
                        <option value="Minivan">Minivan</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year">Year</label>
                <div class="col-md-4">
                    <input id="year" name="year" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="engine">Engine capacity</label>
                <div class="col-md-4">
                    <input id="engine" name="engine" type="text" placeholder="2.5" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="at">Transmission</label>
                <div class="col-md-4">
                    <label class="radio-inline" for="at-0">
                        <input type="radio" name="at" id="at-0" value="1" checked="checked">
                        Automatic
                    </label>
                    <label class="radio-inline" for="at-1">
                        <input type="radio" name="at" id="at-1" value="0">
                        Manual
                    </label>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="driveunit">Drive unit</label>
                <div class="col-md-4">
                    <select id="driveunit" name="driveunit" class="form-control">
                        <option value="FWD">FWD</option>
                        <option value="RWD">RWD</option>
                        <option value="4WD">4WD</option>
                        <option value="AWD">AWD</option>
                    </select>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="equipment">Equipment</label>
                <div class="col-md-4">
                    <select id="equipment" name="equipment" class="form-control">
                        <option value="Base">Base</option>
                        <option value="Minimal">Minimal</option>
                        <option value="Middle">Middle</option>
                        <option value="Top">Top</option>
                        <option value="Premium">Premium</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="millage">Millage</label>
                <div class="col-md-4">
                    <input id="millage" name="millage" type="text" placeholder="" class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="crashed">Crashed/restored</label>
                <div class="col-md-4">
                    <label class="radio-inline" for="crashed-0">
                        <input type="radio" name="crashed" id="crashed-0" value="0" checked="checked">
                        No
                    </label>
                    <label class="radio-inline" for="crashed-1">
                        <input type="radio" name="crashed" id="crashed-1" value="1">
                        Yes
                    </label>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <input id="price" name="price" type="text" placeholder="1500.75" class="form-control input-md" required="">

                </div>
            </div>

            <!-- File Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="upload">Upload photo</label>
                <div class="col-md-4">
                    <input id="upload" name="upload" class="input-file" type="file">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createad"></label>
                <div class="col-md-4">
                    <button id="createad" name="createad" class="btn btn-primary">Create</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>

