-- DATOS DE EJEMPLO PARA VER EL FUNCIONAMIENTO MEJOR

-- Limpiar datos previos 
DELETE FROM obras;
DELETE FROM exposiciones;

--  EXPOSICIONES
INSERT INTO exposiciones (id, titulo, ciudad, fecha_inicio, fecha_fin) VALUES
-- Pasadas
(1,  'Impresionismo: Luz y Color',         'París',       '2024-01-15', '2024-04-30'),
(2,  'El Renacimiento Italiano',            'Florencia',   '2024-03-01', '2024-07-31'),
-- En curso (referencia: mayo 2026)
(3,  'Dalí: El Universo Surrealista',       'Madrid',      '2026-02-10', '2026-08-30'),
(4,  'Voces Emergentes — Arte Actual',      'Barcelona',   '2026-04-01', '2026-09-15'),
(5,  'Arte Latinoamericano Contemporáneo',  'Ciudad de México', '2026-03-20', '2026-10-01'),
-- Próximas
(6,  'Van Gogh: Cartas desde el Sur',       'Ámsterdam',   '2026-07-01', '2026-12-15'),
(7,  'Maestros del Barroco',                'Roma',        '2026-09-10', '2027-02-28');

--  OBRAS

-- Expo 1
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('Impresión, sol naciente',   'Claude Monet',         1872, 'Óleo sobre lienzo',    4200000, 1),
('El baile en el Moulin de la Galette', 'Pierre-Auguste Renoir', 1876, 'Óleo sobre lienzo', 3800000, 1),
('La clase de baile',         'Edgar Degas',          1874, 'Óleo sobre lienzo',    2900000, 1),
('La hamaca',                 'Berthe Morisot',       1884, 'Óleo sobre lienzo',     980000, 1),
('Efecto de nieve en Argenteuil', 'Alfred Sisley',    1874, 'Óleo sobre lienzo',     750000, 1);

-- Expo 2
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('El nacimiento de Venus',    'Sandro Botticelli',    1485, 'Temple sobre tabla',   9500000, 2),
('La Anunciación',            'Leonardo da Vinci',    1472, 'Temple y óleo sobre tabla', 8800000, 2),
('David',                     'Miguel Ángel',         1504, 'Escultura en mármol',  12000000, 2),
('La Escuela de Atenas',      'Rafael Sanzio',        1511, 'Fresco',               11000000, 2),
('Retrato de mujer joven',    'Piero del Pollaiuolo', 1470, 'Temple sobre tabla',     620000, 2);

-- Expo 3
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('La persistencia de la memoria', 'Salvador Dalí',    1931, 'Óleo sobre lienzo',   18000000, 3),
('El gran masturbador',           'Salvador Dalí',    1929, 'Óleo sobre lienzo',    9200000, 3),
('Sueño causado por el vuelo de una abeja', 'Salvador Dalí', 1944, 'Óleo sobre tabla', 7500000, 3),
('La Madonna de Port Lligat',     'Salvador Dalí',    1950, 'Óleo sobre lienzo',    6100000, 3),
('Galatea de las esferas',        'Salvador Dalí',    1952, 'Óleo sobre lienzo',    5400000, 3);

-- Expo 4
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('Fragmentos de identidad',   'Lucía Valls',          2022, 'Acrílico sobre tela',    18000, 4),
('Ciudad en llamas',          'Marc Fontseré',        2023, 'Fotografía digital',      12500, 4),
('Sin título #7',             'Amara Diallo',         2021, 'Instalación mixta',       35000, 4),
('Ecos del silencio',         'Inés Carretero',       2024, 'Escultura en resina',     28000, 4),
('Raíces',                    'Tomás Guerrero',       2023, 'Óleo y collage',          22000, 4);

-- Expo 5
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('Autorretrato con collar de espinas', 'Frida Kahlo', 1940, 'Óleo sobre lienzo',   14000000, 5),
('El hombre en llamas',       'José Clemente Orozco', 1939, 'Fresco',               8500000, 5),
('Sueño de una tarde dominical', 'Diego Rivera',      1947, 'Fresco sobre lienzo',  9800000, 5),
('Manifestación',             'Antonio Berni',        1934, 'Óleo sobre arpillera',  3200000, 5),
('Abaporu',                   'Tarsila do Amaral',    1928, 'Óleo sobre lienzo',    6700000, 5);

-- Expo 6 
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('La noche estrellada',       'Vincent van Gogh',     1889, 'Óleo sobre lienzo',   25000000, 6),
('Los girasoles',             'Vincent van Gogh',     1888, 'Óleo sobre lienzo',   22000000, 6),
('El dormitorio en Arlés',    'Vincent van Gogh',     1889, 'Óleo sobre lienzo',   19500000, 6),
('Autorretrato con oreja vendada', 'Vincent van Gogh',1889, 'Óleo sobre lienzo',   17000000, 6),
('Campo de trigo con cuervos','Vincent van Gogh',     1890, 'Óleo sobre lienzo',   15800000, 6);

-- Expo 7 
INSERT INTO obras (titulo, autor, año_creacion, tecnica, valor_euros, exposicion_id) VALUES
('Las Meninas',               'Diego Velázquez',      1656, 'Óleo sobre lienzo',   30000000, 7),
('La ronda de noche',         'Rembrandt van Rijn',   1642, 'Óleo sobre lienzo',   28000000, 7),
('Judith decapitando a Holofernes', 'Artemisia Gentileschi', 1620, 'Óleo sobre lienzo', 9500000, 7),
('El éxtasis de Santa Teresa','Gian Lorenzo Bernini', 1652, 'Escultura en mármol', 18000000, 7),
('Baco',                      'Caravaggio',           1596, 'Óleo sobre lienzo',   11000000, 7);