-- DATABASE AND USER CREATION
create database miTiendaSpringColasChisela;
use miTiendaSpringColasChisela;
grant all privileges on miTiendaSpringColasChisela.* to 'colasChisela'@'%' identified by 'colasChisela';


create table miTiendaSpringColasChisela.color (
	code VARCHAR(7),
	name VARCHAR(20) NOT NULL,
	description VARCHAR(50),
    CONSTRAINT PK_color PRIMARY KEY (code)
);

-- INSERT color TABLE 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#253ccc', 'Green', 'Asteraceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#70ff0d', 'Turquoise', 'Iridaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#680471', 'White', 'Convolvulaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#777fa2', 'Khaki', 'Cucurbitaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#39b8a8', 'Violet', 'Polypodiaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#5752dc', 'Fuscia', 'Fabaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#a5b3c1', 'Maroon', 'Asteraceae');
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#29961e', 'Yellow', 'Chenopodiaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#6f6919', 'Red', 'Rutaceae'); 
insert into miTiendaSpringColasChisela.color (code, name, description) values ('#fae6c1', 'Blue', 'Iridaceae'); 

create table miTiendaSpringColasChisela.flower (
	code INT,
	name VARCHAR(50) UNIQUE NOT NULL,
	description VARCHAR(100),
	price DECIMAL(4,2) NOT NULL,
	color VARCHAR(7),
	stock INT NOT NULL,
    CONSTRAINT PK_flower PRIMARY KEY (code),
    CONSTRAINT FK_flower FOREIGN KEY (color) REFERENCES miTiendaSpringColasChisela.color (code) ON DELETE CASCADE
); 

-- INSERT flower TABLE
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (1, 'Bearded Milkvetch', 'Astragalus villosus', 10.61, '#253ccc', 30);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (2, 'Sensitive Partridge Pea', 'Chamaecrista nictitans', 4.49, '#253ccc', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (3, 'Bracted Colicroot', 'Aletris bracteata', 14.49, '#70ff0d', 24);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (4, 'Italian Lords And Ladies', 'Arum italicum', 4.52, '#253ccc', 5);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (5, 'Goatgrass', 'Aegilops comosa', 13.3, '#680471', 76);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (6, 'Bleeding Heart', 'Lamprocapnos', 15.4, '#777fa2', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (7, 'Bouquet Mudplantain', 'Heteranthera multiflora', 8.13, '#39b8a8', 345);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (8, 'Sandmat', 'Chamaesyce keyensis', 17.08, '#253ccc', 234);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (9, 'Howell''s Reedgrass', 'Calamagrostis howellii', 17.78, '#5752dc', 45);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (10, 'Distant Phacelia', 'Phacelia distans', 14.95, '#a5b3c1', 65);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (11, 'Manyseed Goosefoot', 'Chenopodium polyspermum', 14.79, '#29961e', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (12, 'Purple Moorgrass', 'Molinia caerulea', 17.19, '#777fa2', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (13, 'Branching Phacelia', 'Phacelia ramosissima', 17.69, '#253ccc', 23);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (14, 'Scribble Lichen', 'Opegrapha rupestris', 0.62, '#6f6919', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (15, 'Tape Dwarf Polypody', 'Grammitis hessii', 13.1, '#70ff0d', 1);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (16, 'Orange Wall Lichen', 'Xanthoria polycarpa', 15.97, '#6f6919', 120);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (17, 'Kneeling Angelica', 'Angelica genuflexa', 2.24, '#29961e', 23);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (18, 'Lasianthus', 'Lasianthus Jack', 6.71, '#fae6c1', 345);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (19, 'Beetle Spurge', 'Euphorbia eriantha', 3.62, '#fae6c1', 6);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (20, 'Lone Mesa Snakeweed', 'Gutierrezia elegans', 5.96, '#777fa2', 678);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (21, 'Bowl Lichen', 'Psoroma', 2.59, '#39b8a8', 50);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (22, 'Alpine Bluegrass', 'Poa alpina', 1.7, '#680471', 10);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (23, 'Stargrass', 'Cynodon plectostachyus', 16.43, '#6f6919', 12);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (24, 'Southwestern False Cloak Fern', 'Argyrochosma limitanea', 0.95, '#680471', 45);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (25, 'Luquillo Mountain Babyboot Orchid', 'Lepanthes eltoroensis', 5.94, '#fae6c1', 1);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (26, 'Spanish Moss', 'Tillandsia usneoides', 14.98, '#253ccc', 5);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (27, 'Tufted Wallaby Grass', 'Rytidosperma caespitosum', 14.06, '#5752dc', 67);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (28, 'Shortfruit Willow', 'Salix brachycarpa', 12.47, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (29, 'Rocketsalad', 'Eruca', 2.75, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (30, 'Sharpleaf Snowberry', 'Symphoricarpos acutus', 4.82, '#680471', 209);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (31, 'Oreganillo', 'Koanophyllon dolicholepis', 0.63, '#a5b3c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (32, 'Alaskan Glacier Buttercup', 'Ranunculus glacialis', 2.49, '#70ff0d', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (33, 'Chaparral Nightshade', 'Solanum xanti', 5.49, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (34, 'Tall Blazing Star', 'Liatris aspera', 17.19, '#5752dc', 208);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (35, 'Sandberg''s Biscuitroot', 'Lomatium sandbergii', 13.25, '#253ccc', 50);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (36, 'Broadleaf Stonecrop', 'Sedum spathulifolium', 7.41, '#253ccc', 25);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (37, 'Mountain Oxytrope', 'Oxytropis oreophila', 11.81, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (38, 'Teasel Clover', 'Trifolium retusum', 12.81, '#680471', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (39, 'Miracle Fruit', 'Thaumatococcus daniellii', 9.09, '#777fa2', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (40, 'Rangoon Creeper', 'Quisqualis', 13.88, '#fae6c1', 10);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (41, 'Browneyed Susan', 'Rudbeckia triloba', 5.64, '#6f6919', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (42, 'Spikeoat', 'Avenula hookeri', 15.87, '#29961e', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (43, 'Lean Flatsedge', 'Cyperus setigerus', 3.62, '#6f6919', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (44, '''ohi''a Lehua', 'Metrosideros polymorpha', 5.45, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (45, 'Map Lichen', 'Rhizocarpon pusillum', 14.86, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (46, 'Foothill Rush', 'Juncus trilocularis', 16.66, '#a5b3c1', 25);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (47, 'Ruby Saltbush', 'Enchylaena tomentosa', 14.46, '#253ccc', 205);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (48, 'Poison Suckleya', 'Suckleya suckleyana', 9.41, '#fae6c1', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (49, 'Lophosoria', 'Lophosoria', 14.95, '#777fa2', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (50, 'Woods'' Rose', 'Rosa woodsii', 15.59, '#39b8a8', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (51, 'Island Blackberry', 'Rubus insulanus', 11.65, '#777fa2', 205);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (52, 'Visher''s Buckwheat', 'Eriogonum visheri', 5.57, '#6f6919', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (53, 'Colza', 'Brassica rapa', 19.6, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (54, 'West Indian Bristlegrass', 'Setaria setosa', 18.45, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (55, 'Centipede Grass', 'Eremochloa', 5.92, '#a5b3c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (56, 'Shale Barren Evening Primrose', 'Oenothera argillicola', 10.64, '#777fa2', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (57, 'Yellow Spiderflower', 'Cleome lutea', 8.77, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (58, 'Bartramia Moss', 'Bartramia pomiformis', 16.88, '#680471', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (59, 'Sidebeak Pencilflower', 'Stylosanthes biflora', 14.78, '#29961e', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (60, 'Running Strawberry Bush', 'Euonymus obovatus', 5.44, '#70ff0d', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (61, 'Bush''s Goosefoot', 'Chenopodium berlandieri', 16.78, '#680471', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (62, 'Green Monardella', 'Monardella viridis', 6.6, '#a5b3c1', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (63, 'Seaside Kirschsteiniothelia Lichen', 'Kirschsteiniothelia maritima', 18.22, '#29961e', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (64, 'Spiked Saxifrage', 'Saxifraga spicata', 18.49, '#6f6919', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (65, 'Bluntlobe Grapefern', 'Botrychium oneidense', 1.35, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (66, 'Dwarf Groundsmoke', 'Gayophytum humile', 17.31, '#29961e', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (67, 'Wax Mallow', 'Malvaviscus arboreus', 5.09, '#777fa2', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (68, 'Thickleaf Pepperweed', 'Lepidium integrifolium', 8.26, '#a5b3c1', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (69, 'Vervain', 'Verbena moechina', 2.98, '#777fa2', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (70, 'Tree Morning Glory', 'Ipomoea pauciflora', 6.69, '#680471', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (71, 'Slender Toothwort', 'Cardamine angustata', 18.09, '#253ccc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (72, 'Tracy''s Desertparsley', 'Lomatium tracyi', 16.81, '#70ff0d', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (73, 'Shrubby Cinquefoil', 'Dasiphora', 4.22, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (74, 'Hidden Buckwheat', 'Eriogonum capistratum', 6.1, '#fae6c1', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (75, 'Wallowa Onion', 'Allium tolmiei', 15.69, '#5752dc', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (76, 'Rixford''s Rockwort', 'Scopulophila rixfordii', 12.27, '#680471', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (77, 'Rush Milkweed', 'Asclepias subulata', 4.32, '#6f6919', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (78, 'Dunebroom', 'Errazurizia', 3.64, '#39b8a8', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (79, 'Mata Gallina', 'Dioscorea polygonoides', 13.32, '#680471', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (80, 'Honokahua Melicope', 'Melicope orbicularis', 7.04, '#70ff0d', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (81, 'Purple Muhly', 'Muhlenbergia rigida', 4.28, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (82, 'Boyd''s Maiden Fern', 'Thelypteris boydiae', 12.74, '#253ccc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (83, 'Seaside Alder', 'Alnus maritima', 18.71, '#29961e', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (84, 'Texas Rush', 'Juncus texanus', 6.58, '#6f6919', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (85, 'Talinopsis', 'Talinopsis', 18.28, '#680471', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (86, 'Arrowleaf Violet', 'Viola sagittata', 11.46, '#39b8a8', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (87, 'Blackspore Quillwort', 'Isoetes melanospora', 4.08, '#fae6c1', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (88, 'Elmer''s Blue-eyed Grass', 'Sisyrinchium elmeri', 4.78, '#777fa2', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (89, 'Elongate Dropseed', 'Sporobolus elongatus', 11.75, '#a5b3c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (90, 'Yerba De Estrella', 'Rhynchospora ciliata', 17.55, '#5752dc', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (91, 'California Hedgenettle', 'Stachys bullata', 13.49, '#39b8a8', 205);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (92, 'Sumac', 'Rhus', 7.16, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (93, 'Shortleaf Spikesedge', 'Kyllinga brevifolia', 8.13, '#29961e', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (94, 'Ptychomitrium Moss', 'Ptychomitrium', 16.49, '#29961e', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (95, 'Kihifern', 'Adenophorus', 14.31, '#39b8a8', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (96, 'Rosette Lichen', 'Physcia', 15.85, '#fae6c1', 30);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (97, 'Charleston Sandwort', 'Arenaria congesta', 12.37, '#6f6919', 0);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (98, 'Appalachian Violet', 'Viola appalachiensis', 16.93, '#5752dc', 2);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (99, 'Chinquapin', 'Chrysolepis', 19.13, '#fae6c1', 20);
insert into miTiendaSpringColasChisela.flower (code, name, description, price, color, stock) values (100, 'Mescalero Milkwort', 'Polygala rimulicola', 1.07, '#777fa2', 10);

-- AUTO INCREMENT FOR flower CODE
ALTER TABLE miTiendaSpringColasChisela.flower MODIFY code INT AUTO_INCREMENT, AUTO_INCREMENT=101;

create table users (
	username VARCHAR(50),
	password VARCHAR(64) NOT NULL, 
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50),
	admin VARCHAR(5),
	verification_code VARCHAR(64),
	enabled VARCHAR(5),
	img VARCHAR(200),
    CONSTRAINT PK_users PRIMARY KEY (username)
); 

-- INSERT users TABLE 
insert into users (username, password, name, email, admin, verification_code, enabled, img) values ('ioliasa', '$2a$10$XjLnSakKnpxzWxSnu/WIbuij2gHDhsnl32vB7KJxE10McLoz2usnS', 'Inmaculada Olias', 'ioliasa@gmail.com', true, null, true, 'https://res.cloudinary.com/ddrd0qdr2/image/upload/v1674458044/sample.jpg'); -- 1 admin 0 no admin se guardará
insert into users (username, password, name, email, admin, verification_code, enabled, img) values ('user_inma', '$2a$10$MXfDMkJe4YBow7QbqOMD4Oz2KZ4Sl57T/N2WJBoMFwt.w8pGmmu0C', 'Inma Olias', 'ioliasa@gmail.com', false, null, true, 'https://res.cloudinary.com/ddrd0qdr2/image/upload/v1674458044/sample.jpg');
insert into users (username, password, name, email, admin, verification_code, enabled, img) values ('chisela', '$2a$10$IL/f8Y5Dv2r9f/Vt2jfjx.JdmEHjjrbPGq8jq98a6Vj/LetDdkvVS', 'Chisela Colás', 'chisela14@gmail.com', true, null, true, 'https://res.cloudinary.com/ddrd0qdr2/image/upload/v1674458044/sample.jpg');
insert into users (username, password, name, email, admin, verification_code, enabled, img) values ('user_chisela', '$2a$10$QxrmcJ7vjMCtfzgms9njmOLq65XgH3360tePAk3zPrsYNapLGP4uy', 'Chisela Colás', 'chisela14@gmail.com', false, null, true, 'https://res.cloudinary.com/ddrd0qdr2/image/upload/v1674458044/sample.jpg');


create table orders (
	code INT(11), 
	user_code VARCHAR(50),
	flower_code INT,
	iva INT,
	date DATE,
	quantity INT,
    CONSTRAINT PK_orders PRIMARY KEY (code),
    CONSTRAINT FK_orders FOREIGN KEY (user_code) REFERENCES miTiendaSpringColasChisela.users (username) ON DELETE CASCADE,
    CONSTRAINT FK2_orders FOREIGN KEY (flower_code) REFERENCES miTiendaSpringColasChisela.flower (code) ON DELETE CASCADE
);
-- INSERT orders TABLE 
insert into orders (code, user_code, flower_code, iva, date, quantity) values (1, 'chisela', 76, 21, '2019-03-29', 2);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (2, 'chisela', 95, 21, '2011-11-12', 5);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (3, 'chisela', 65, 10, '2022-07-15', 1);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (4, 'chisela', 48, 21, '2013-11-28', 5);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (5, 'ioliasa', 25, 21, '2021-08-31', 4);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (6, 'ioliasa', 24, 21, '2017-10-21', 6);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (7, 'ioliasa', 43, 21, '2021-06-10', 3);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (8, 'ioliasa', 54, 0, '2022-01-17', 1);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (9, 'user_inma', 36, 10, '2018-11-12', 4);
insert into orders (code, user_code, flower_code, iva, date, quantity) values (10, 'user_chisela', 93, 4, '2017-05-24', 7);

ALTER TABLE orders MODIFY code INT AUTO_INCREMENT, AUTO_INCREMENT=11;

