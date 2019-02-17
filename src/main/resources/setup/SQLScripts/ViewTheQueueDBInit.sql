DROP DATABASE IF EXISTS ViewTheQueueDB;
CREATE DATABASE ViewTheQueueDB;
USE ViewTheQueueDB;
CREATE TABLE parks(
    park_name varchar(32) NOT NULL,
    description varchar(120),
    operation_status varchar(6) NOT NULL,
    opening_time time,
    closing_time time,
    primary key (park_name)
);
CREATE TABLE attractions(
    attraction_name varchar(60) NOT NULL,
    description varchar(120),
    park_name varchar(32) NOT NULL,
    area varchar(32) NOT NULL,
    operation_status varchar(6) NOT NULL,
    opening_time time,
    closing_time time,
    wait_time int NOT NULL,
    max_height_restriction_inches int,
    min_height_restriction_inches int,
    is_wheel_chair_accessible bit(1) NOT NULL,
    has_express_line bit(1) NOT NULL,
    has_single_rider bit(1) NOT NULL,
    primary key (attraction_name, park_name));
CREATE TABLE restaurants(
    restaurant_name varchar(32) NOT NULL,
    description varchar(120),
    park_name varchar(32) NOT NULL,
    area varchar(32) NOT NULL,
    operation_status varchar(6) NOT NULL,
    opening_time time,
    closing_time time,
    serves_vegetarian bit(1) NOT NULL,
    serves_vegan bit(1) NOT NULL,
    primary key (restaurant_name, park_name));
CREATE TABLE shows(
    show_name varchar(32) NOT NULL,
    description varchar(120),
    park_name varchar(32) NOT NULL,
    area varchar(32) NOT NULL,
    operation_status varchar(6) NOT NULL,
    is_wheelchair_accessible bit(1) NOT NULL,
    has_express_line bit(1) NOT NULL,
    show_times varchar(70),
    primary key (show_name, park_name));
INSERT INTO parks VALUES
    ('Animal World', 'A wild expedition into the Animal World', 'Open', '08:00', '22:00'),
    ('Sunset Studios', 'Step into the glamor and glitz of Sunset Studios', 'Open', '09:00', '21:00'),
    ('Tulip Gardens', 'Excitement and wonder awaits you at Tulip Gardens', 'Closed', null, null);
INSERT INTO attractions VALUES
    ('Shrine Of Ataraxia', 'Take the forbidden voyage into the mysterious Shrine. Watch out for the Snakes.', 'Animal World', 'Grand Duck Prairie', 'Open', '08:00', '22:00', 10, null, null, 1, 0, 0),
    ('Duck Boat Cruises', 'Enjoy a relaxing cruise through the prairielands.', 'Animal World', 'Grand Duck Prairie', 'Open', '08:00', '22:00', 5, null, null, 1, 0, 0),
    ('Crocodile Beck', 'Water Beasts await you on this walking tour of Crocodile Beck.', 'Animal World', 'Grand Duck Prairie', 'Open', '08:00', '20:00', 20, null, 84, 1, 0, 0),
    ('Mulcouche Summit Bobsleds', 'Take a trip downhill oboard your own Bobsled.', 'Animal World', 'Grand Duck Prairie', 'Open', '08:00', '19:00', 35, 48, null, 1, 1, 1),
    ('Rainforest Trails', 'Let your adventurous side roam free on the Rainforest Trails.', 'Animal World', 'Wandering Grassland', 'Open', '08:00', '22:00', 10, 60, null, 1, 0, 0),
    ('Serenity Safari', 'See the Savanna and all the wildlife living there.', 'Animal World', 'Wandering Grassland', 'Open', '08:00', '22:00', 5, 60, null, 1, 0, 0),
    ('The Smirkus Big Top', 'Race through The Smirkus Big Top and Save Little Blue.', 'Animal World', 'Pleasant Territory', 'Closed', null, null, 20, null, 84, 1, 0, 0),
    ('Woodstino Volcano', 'Explosions are abundant at this mysterious place.', 'Animal World', 'Pleasant Territory', 'Open', '08:00', '20:00', 20, 60, 84, 1, 1, 1),
    ('Downhill Mining Company Railroad', 'There is only one place that this mine train is headed and that is downhill!', 'Animal World', 'Pleasant Territory', 'Open', '08:00', '20:00', 20, 60, 84, 1, 0, 0),
    ('Big Picture Productions', 'Experience what it takes to make our Hollywood blockbusters.', 'Sunset Studios', 'Oak Boulevard', 'Open', '09:00', '21:00', 10, null, null, 1, 0, 0),
    ('Alien Invasion', 'They are here and they are dangerous! Save the planet!', 'Sunset Studios', 'Oak Boulevard', 'Open', '09:00', '21:00', 5, null, null, 1, 0, 0),
    ('Rock to the Top', 'Slide down guitar strings aboard a super speed car.', 'Sunset Studios', 'Oak Boulevard', 'Open', '10:00', '20:00', 90, null, 84, 1, 1, 1),
    ('Ride the Musicals', 'Take a tour through some of your favorite movie musicals. Sing-a-long! You know the words!', 'Sunset Studios', 'Oak Boulevard', 'Open', '09:00', '19:00', 35, 48, null, 1, 1, 1),
    ('Studio Tram Tour', 'Here is your chance to get backstage on one of our movies.', 'Sunset Studios', 'Backlot', 'Open', '09:00', '21:00', 10, 60, null, 1, 1, 1),
    ('Digging Grounds Play Area', 'Children of all ages can explore the Digging Grounds.', 'Sunset Studios', 'Backlot', 'Closed', null, null, 5, 60, null, 1, 1, 1),
    ('Disaster Canyon', 'Watch out for falling rocks as you enter the arena of our special effects.', 'Sunset Studios', 'Backlot', 'Open', '09:00', '21:00', 5, 60, null, 1, 1, 1),
    ('Escape from the Lost Planet The Ride', 'You saw it on the big screen, now experience it live!', 'Sunset Studios', 'Commissary Courtyard', 'Open', '09:00', '19:00', 20, null, 84, 1, 1, 1),
    ('You Could Be in the Movies Too', 'Here is your chance to be in the movies. Check your times guide for auditions times.', 'Sunset Studios', 'Commissary Courtyard', 'Open', '09:00', '20:00', 120, 60, 84, 1, 1, 1),
    ('Space Marine Training Academy', 'This is it, rookie! Enter the SMTA and save earth!', 'Sunset Studios', 'Commissary Courtyard', 'Open', '09:00', '20:00', 20, 60, 84, 1, 0, 0),
    ('The Legendary Oasis', 'Tour the gardens and see the falls.', 'Tulip Gardens', 'Stone Lake Meadows', 'Closed', null, null, 0, null, null, 1, 0, 0),
    ('Emerald Channel', 'Tour Tulip Gardens on a slow boat on the Emerald Channel.', 'Tulip Gardens', 'Stone Lake Meadows', 'Closed', null, null, 0, null, null, 1, 0, 0),
    ('The Enchanted Swing', 'Find out the true secret behind the curse, take a ride on The Haunted Swing!', 'Tulip Gardens', 'Stone Lake Meadows', 'Closed', null, null, 0, null, 84, 1, 0, 0),
    ('Winterborg Hill Dippers', 'An exhilarating thrill ride over the peaks of Winterborg Hill.', 'Tulip Gardens', 'Elm Grounds', 'Closed', null, null, 0, 60, null, 1, 0, 0),
    ('The Haunted Caverns', 'Enter the Haunted Caverns, if you dare!', 'Tulip Gardens', 'Elm Grounds', 'Closed', null, null, 0, 60, null, 1, 0, 0),
    ('The Rickety Old Gold Mine', 'There be gold down those mines! Hold on to your hats.', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', null, null, 0, null, 84, 1, 1, 1),
    ('Turbulent River Adventure', 'Climb aboard a log and slide down the Turbulent River Adventure.', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', null, null, 0, null, 84, 1, 1, 1),
    ('The Paranormal Estate', 'Come and investigate the ghost sightings. Once you enter, you may not exit.', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', null, null, 0, 60, 84, 1, 1, 1),
    ('Stampede Racers', 'Saddle up and hold on to your horses on this wild ride through the west!', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', null, null, 0, 60, 84, 1, 1, 1);
INSERT INTO restaurants VALUES
    ('Bread & Batter', 'Exquisite bakery items to satisfy your desires.', 'Animal World', 'Grand Duck Prairie', 'Open', '08:00', '20:00', 1, 1),
    ('Ms. Carrie''s Cafe', 'Ms. Carrie will welcome you into her exquisit bakery.', 'Animal World', 'Grand Duck Prairie', 'Open', '08:00', '21:00', 1, 1),
    ('The Curry Leaf', 'All you can eat, spicy and sweet!', 'Animal World', 'Wandering Grassland', 'Open', '09:30', '22:00', 1, 0),
    ('Woodstino Steakhouse', 'Watch the volcano errupt while you enjoy a feast!', 'Animal World', 'Pleasant Territory', 'Closed', null, null, 1, 1),
    ('The Honey Shack', 'Turkey legs and a honey ham stack. Come and join us at The Honey Shack.', 'Animal World', 'Pleasant Territory', 'Open', '10:00', '21:00', 0, 1),
    ('Sweet Tooth Confectionery', 'Serving everything to satisfy your sweet tooth.', 'Sunset Studios', 'Oak Boulevard', 'Open', '08:00', '22:00', 1, 1),
    ('The Spaghetti Exhibit', 'Take a break from the movie set and take a visit to Litle Italy.', 'Sunset Studios', 'Backlot', 'Open', '08:00', '22:00', 1, 1),
    ('Dangerous Dan''s Disasters', 'Watch out! Dangerous Dan is cooking up another disaster!', 'Sunset Studios', 'Backlot', 'Open', '08:00', '22:00', 1, 0),
    ('The Commissary', 'Dine with the stars. You never know who you might see!', 'Sunset Studios', 'Commissary Courtyard', 'Open', '08:00', '22:00', 1, 1),
    ('The Mammoth Flower', 'Juicy burgers and other American favorites!', 'Tulip Gardens', 'Stone Lake Meadows', 'Closed', null, null, 1, 1),
    ('The Peacock', 'French fine dining awaits you at The Peacock.', 'Tulip Gardens', 'Stone Lake Meadows', 'Closed', null, null, 1, 0),
    ('Fable''s Chocolate Factory', 'Ooie and gooie luxury chocolates. Mmmmmm!', 'Tulip Gardens', 'Elm Grounds', 'Closed', null, null, 1, 1),
    ('The Stomping Saloon', 'Clap your hands and raise your glasses at this Wild West Musical Extravaganza!', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', null, null, 1, 1),
    ('Taco Carriage', 'Grab your favorite eats when the Taco Carriage rolls into town!', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', null, null, 1, 1);
INSERT INTO shows VALUES
    ('African Jungle Festival', 'Celebrate the arrival of the Jungle Festival!', 'Animal World', 'Wandering Grassland', 'Open', 1, 1, '11:30am, 1:00pm, 3:00pm, 5:30pm, 7:00pm'),
    ('Bird Empire', 'Experience the thrills of flying with beautiful birds of prey.', 'Animal World', 'Pleasant Territory', 'Open', 1, 0, '11:30am, 1:00pm, 3:00pm, 5:30pm'),
    ('The Prophecy Stone', 'Come and learn the secrets behind the mysterious Prophecy Stone.', 'Animal World', 'Pleasant Territory', 'Open', 1, 1, '1:00pm, 3:00pm, 5:00pm, 7:00pm'),
    ('The Magic Lantern Theater', 'Catch all the blockbusters now in live action!', 'Sunset Studios', 'Oak Boulevard', 'Open', 1, 1, '11:30am, 1:00pm, 5:30pm, 7:00pm'),
    ('Mind Shifting Productions', 'You''ll believe in magic when you witness the Master Mind Shifter.', 'Sunset Studios', 'Oak Boulevard', 'Open', 1, 0, '11:30am, 1:00pm, 3:00pm, 5:30pm, 7:00pm'),
    ('Oblivion Terrace', 'Join Dr. Teryl as he creates your favorite Hollywood monstors!', 'Sunset Studios', 'Backlot', 'Open', 1, 1, '11:30am, 1:00pm, 3:00pm, 5:30pm'),
    ('The Bluebell Cinema', 'A revue of the movies that left you in stitches!', 'Sunset Studios', 'Commissary Courtyard', 'Open', 1, 0, '11:30am, 1:00pm, 3:00pm, 5:30pm, 7:00pm'),
    ('The Fifth Sphere', 'Magical floral arrangements dance before your very eyes!', 'Tulip Gardens', 'Stone Lake Meadows', 'Closed', 1, 1, null),
    ('Lost Soul Graveyard', 'When night falls, the dead will rise!', 'Tulip Gardens', 'Elm Grounds', 'Closed', 1, 0, null),
    ('Wild West Stunt Town', 'Everything is pleasant in the sleep town of Briar Ridge. That is until Outlaw Sparky comes to town.', 'Tulip Gardens', 'Pioneer Plaza', 'Closed', 1, 1, null);